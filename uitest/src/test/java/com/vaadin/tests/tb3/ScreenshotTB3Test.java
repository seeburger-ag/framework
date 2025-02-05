/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tb3;

import com.vaadin.testbench.Parameters;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.parallel.BrowserUtil;
import com.vaadin.testbench.screenshot.ImageFileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class which provides functionality for tests which use the automatic
 * screenshot comparison function.
 *
 * @author Vaadin Ltd
 */
public abstract class ScreenshotTB3Test extends AbstractTB3Test {

    @Rule
    public ScreenshotOnFailureRule screenshotOnFailure = new ScreenshotOnFailureRule(
            this, true) {

        @Override
        protected void failed(Throwable throwable, Description description) {
            super.failed(throwable, description);
            closeApplication();
        }

        @Override
        protected void succeeded(Description description) {
            super.succeeded(description);
            closeApplication();
        }

        @Override
        protected File getErrorScreenshotFile(Description description) {
            return ImageFileUtil
                    .getErrorScreenshotFile(getScreenshotFailureName());
        };
    };

    private String screenshotBaseName;

    @Rule
    public TestRule watcher = new TestWatcher() {

        @Override
        protected void starting(org.junit.runner.Description description) {
            Class<?> testClass = description.getTestClass();
            // Runner adds [BrowserName] which we do not want to use in the
            // screenshot name
            String testMethod = description.getMethodName();
            testMethod = testMethod.replaceAll("\\[.*\\]", "");

            String className = testClass.getSimpleName();
            screenshotBaseName = className + "-" + testMethod;
        }
    };

    /**
     * Contains a list of screenshot identifiers for which
     * {@link #compareScreen(String)} has failed during the test
     */
    private List<String> screenshotFailures;

    /**
     * Defines TestBench screen comparison parameters before each test run
     */
    @Before
    public void setupScreenComparisonParameters() {
        screenshotFailures = new ArrayList<String>();
    }

    /**
     * Grabs a screenshot and compares with the reference image with the given
     * identifier. Supports alternative references and will succeed if the
     * screenshot matches at least one of the references.
     *
     * In case of a failed comparison this method stores the grabbed screenshots
     * in the error directory as defined by
     * {@link Parameters#getScreenshotErrorDirectory()}. It will also generate a html file
     * in the same directory, comparing the screenshot with the first found
     * reference.
     *
     * @param identifier
     * @throws IOException
     */
    protected void compareScreen(String identifier) throws IOException {
        compareScreen(null, identifier);
    }

    protected void compareScreen(WebElement element, String identifier)
            throws IOException {
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException(
                    "Empty identifier not supported");
        }

        File mainReference = getScreenshotReferenceFile(identifier);

        List<File> referenceFiles = findReferenceAndAlternatives(mainReference);
        List<File> failedReferenceFiles = new ArrayList<File>();

        for (File referenceFile : referenceFiles) {
            boolean match = false;
            if (element == null) {
                // Full screen
                match = testBench(driver).compareScreen(referenceFile);
            } else {
                // Only the element
                match = customTestBench(driver).compareScreen(element,
                        referenceFile,
                        BrowserUtil.isIE8(getDesiredCapabilities()));
            }
            if (match) {
                // There might be failure files because of retries in TestBench.
                deleteFailureFiles(getErrorFileFromReference(referenceFile));
                break;
            } else {
                failedReferenceFiles.add(referenceFile);
            }
        }

        File referenceToKeep = null;
        if (failedReferenceFiles.size() == referenceFiles.size()) {
            // Ensure we use the correct browser version (e.g. if running IE11
            // and only an IE 10 reference was available, then mainReference
            // will be for IE 10, not 11)
            String originalName = getScreenshotReferenceName(identifier);
            File exactVersionFile = new File(originalName);

            if (!exactVersionFile.equals(mainReference)) {
                // Rename png+html to have the correct version
                File correctPng = getErrorFileFromReference(exactVersionFile);
                File producedPng = getErrorFileFromReference(mainReference);
                File correctHtml = htmlFromPng(correctPng);
                File producedHtml = htmlFromPng(producedPng);

                producedPng.renameTo(correctPng);
                producedHtml.renameTo(correctHtml);
                referenceToKeep = exactVersionFile;
                screenshotFailures.add(exactVersionFile.getName());
            } else {
                // All comparisons failed, keep the main error image + HTML
                screenshotFailures.add(mainReference.getName());
                referenceToKeep = mainReference;
            }
        }

        // Remove all PNG/HTML files we no longer need (failed alternative
        // references or all error files (PNG/HTML) if comparison succeeded)
        for (File failedAlternative : failedReferenceFiles) {
            File failurePng = getErrorFileFromReference(failedAlternative);
            if (failedAlternative != referenceToKeep) {
                // Delete png + HTML
                deleteFailureFiles(failurePng);
            }
        }
        if (referenceToKeep != null) {
            File errorPng = getErrorFileFromReference(referenceToKeep);
            enableAutoswitch(new File(errorPng.getParentFile(),
                    errorPng.getName() + ".html"));
        }
    }

    private CustomTestBenchCommandExecutor customTestBench = null;

    private CustomTestBenchCommandExecutor customTestBench(WebDriver driver) {
        if (customTestBench == null) {
            customTestBench = new CustomTestBenchCommandExecutor(driver);
        }

        return customTestBench;
    }

    private void enableAutoswitch(File htmlFile)
            throws FileNotFoundException, IOException {
        if (htmlFile == null || !htmlFile.exists()) {
            return;
        }

        String html = FileUtils.readFileToString(htmlFile);

        html = html.replace("body onclick=\"",
                "body onclick=\"clearInterval(autoSwitch);");
        html = html.replace("</script>",
                ";autoSwitch=setInterval(switchImage,500);</script>");

        FileUtils.writeStringToFile(htmlFile, html);
    }

    private void deleteFailureFiles(File failurePng) {
        File failureHtml = htmlFromPng(failurePng);

        failurePng.delete();
        failureHtml.delete();
    }

    /**
     * Returns a new File which points to a .html file instead of the given .png
     * file
     *
     * @param png
     * @return
     */
    private static File htmlFromPng(File png) {
        return new File(png.getParentFile(),
                png.getName().replaceAll("\\.png$", ".png.html"));
    }

    /**
     *
     * @param referenceFile
     *            The reference image file (in the directory defined by
     *            {@link Parameters#getScreenshotReferenceDirectory()})
     * @return the file name of the file generated in the directory defined by
     *         {@link Parameters#getScreenshotErrorDirectory()} if comparison with the
     *         given reference image fails.
     */
    private File getErrorFileFromReference(File referenceFile) {

        String absolutePath = referenceFile.getAbsolutePath();
        String screenshotReferenceDirectory = Parameters
                .getScreenshotReferenceDirectory();
        String screenshotErrorDirectory = Parameters
                .getScreenshotErrorDirectory();
        // We throw an exception to safeguard against accidental reference
        // deletion. See (#14446)
        if (!absolutePath.contains(screenshotReferenceDirectory)) {
            throw new IllegalStateException(
                    "Reference screenshot not in reference directory. Screenshot path: '"
                            + absolutePath + "', directory path: '"
                            + screenshotReferenceDirectory + "'");
        }
        return new File(absolutePath.replace(screenshotReferenceDirectory,
                screenshotErrorDirectory));
    }

    /**
     * Finds alternative references for the given files
     *
     * @param reference
     * @return all references which should be considered when comparing with the
     *         given files, including the given reference
     */
    private List<File> findReferenceAndAlternatives(File reference) {
        List<File> files = new ArrayList<File>();
        files.add(reference);

        File screenshotDir = reference.getParentFile();
        String name = reference.getName();
        // Remove ".png"
        String nameBase = name.substring(0, name.length() - 4);
        for (int i = 1;; i++) {
            File file = new File(screenshotDir, nameBase + "_" + i + ".png");
            if (file.exists()) {
                files.add(file);
            } else {
                break;
            }
        }

        return files;
    }

    /**
     * @param identifier
     *          the screenshot name identifier
     * @return the reference file name to use for the given browser, as
     *         described by {@literal capabilities}, and identifier
     */
    private File getScreenshotReferenceFile(String identifier) {
        DesiredCapabilities capabilities = getDesiredCapabilities();

        String originalName = getScreenshotReferenceName(identifier);
        File exactVersionFile = new File(originalName);
        if (exactVersionFile.exists()) {
            return exactVersionFile;
        }

        String browserVersion = capabilities.getVersion();

        // compare against screenshots for this version and older
        // default such that if no particular version is requested, compare with
        // any version
        int maxVersion = 100;
        if (browserVersion.matches("\\d+")) {
            maxVersion = Integer.parseInt(browserVersion);
        }
        for (int version = maxVersion; version > 0; version--) {
            String fileName = getScreenshotReferenceName(identifier, version);
            File oldVersionFile = new File(fileName);
            if (oldVersionFile.exists()) {
                return oldVersionFile;
            }
        }

        return exactVersionFile;
    }

    /**
     * Checks if any screenshot comparisons failures occurred during the test
     * and combines all comparison errors into one exception
     *
     * @throws IOException
     *             If there were failures during the test
     */
    @After
    public void checkCompareFailures() throws IOException {
        if (screenshotFailures != null && !screenshotFailures.isEmpty()) {
            throw new IOException(
                    "The following screenshots did not match the reference: "
                            + screenshotFailures.toString());
        }

    }

    /**
     * @return the name of a "failure" image which is stored in the folder
     *         defined by {@link Parameters#getScreenshotErrorDirectory()} when the test
     *         fails
     */
    private String getScreenshotFailureName() {
        return getScreenshotBaseName() + "_" + getUniqueIdentifier(null, null)
                + "-failure.png";
    }

    /**
     * @return the base name used for screenshots. This is the first part of the
     *         screenshot file name, typically created as "testclass-testmethod"
     */
    public String getScreenshotBaseName() {
        return screenshotBaseName;
    }

    /**
     * Returns the name of the reference file based on the given parameters.
     *
     * @param identifier
     *      the identifier for the screenshot
     * @return the full path of the reference
     */
    private String getScreenshotReferenceName(String identifier) {
        String fileName = getScreenshotReferenceName(identifier, null);
        File refFile = new File(fileName);
        if (!refFile.exists() && getDesiredCapabilities().getVersion().isEmpty()) {
            int version = 100;
            while (version > 0) {
                String tmpName = getScreenshotReferenceName(identifier,version--);
                if (new File(tmpName).exists()) {
                    return tmpName;
                }
            }
        }
        return fileName;
    }

    /**
     * Returns the name of the reference file based on the given parameters. The
     * version given in {@literal capabilities} is used unless it is overridden
     * by the {@literal versionOverride} parameter.
     *
     * @param identifier
     *      the identifier for the screenshot
     * @param versionOverride
     *          the version number to use in the screenshot name
     * @return the full path of the reference
     */
    private String getScreenshotReferenceName(String identifier,
            Integer versionOverride) {
        String fileName = getScreenshotReferenceName(identifier,
                versionOverride, null);
        File refFile = new File(fileName);
        if (!refFile.exists()
                && getDesiredCapabilities().getPlatform() == Platform.ANY) {
            for (Platform p : Platform.values()) {
                String tmpName = getScreenshotReferenceName(identifier,
                        versionOverride, p);
                if (new File(tmpName).exists()) {
                    return tmpName;
                }
            }
        }
        return fileName;
    }

    private String getScreenshotReferenceName(String identifier, Integer versionOverride, Platform platformOverride) {
        return Parameters.getScreenshotReferenceDirectory() + File.separator
                + getScreenshotBaseName() + "_"
                + getUniqueIdentifier(versionOverride, platformOverride) + "_" + identifier
                + ".png";
    }

    private String getUniqueIdentifier(Integer versionOverride, Platform platformOverride) {
        String testNameAndParameters = testName.getMethodName();
        // runTest-wildfly9-nginx[Windows_Firefox_24][/buffering/demo][valo]

        String parameters = testNameAndParameters.substring(
                testNameAndParameters.indexOf("[") + 1,
                testNameAndParameters.length() - 1);
        // Windows_Firefox_24][/buffering/demo][valo

        parameters = parameters.replace("][", "_");
        // Windows_Firefox_24_/buffering/demo_valo

        parameters = parameters.replace("/", "");
        // Windows_Firefox_24_bufferingdemo_valo

        if (versionOverride != null) {
            // Windows_Firefox_17_bufferingdemo_valo
            int indexOfBrowser = parameters.indexOf("_") + 1;
            parameters = parameters.substring(0, indexOfBrowser) + parameters.substring(indexOfBrowser).replaceFirst(
                    "_" + getDesiredCapabilities().getVersion(),
                    "_" + versionOverride);

        }

        if (platformOverride != null) {
            // LINUX_Firefox_17_bufferingdemo_valo
            parameters = getPlatformName(platformOverride)
                    + parameters.substring(parameters.indexOf("_"));
        }

        return parameters;
    }

    private String getPlatformName(Platform platform) {
        switch (platform) {
            case WINDOWS:
                // Reference file names have Windows instead of WINDOWS
                return "Windows";
            default:
                return platform.name();
        }
    }

    /**
     * Returns the base name of the screenshot in the error directory. This is a
     * name so that all files matching {@link #getScreenshotErrorBaseName()}*
     * are owned by this test instance (taking into account
     * {@link #getDesiredCapabilities()}) and can safely be removed before
     * running this test.
     */
    private String getScreenshotErrorBaseName() {
        return getScreenshotReferenceName("dummy", null)
                .replace(Parameters.getScreenshotReferenceDirectory(),
                        Parameters.getScreenshotErrorDirectory())
                .replace("_dummy.png", "");
    }

    /**
     * Removes any old screenshots related to this test from the errors
     * directory before running the test
     */
    @Before
    public void cleanErrorDirectory() {
        // Remove any screenshots for this test from the error directory
        // before running it. Leave unrelated files as-is
        File errorDirectory = new File(Parameters.getScreenshotErrorDirectory());

        // Create errors directory if it does not exist
        if (!errorDirectory.exists()) {
            errorDirectory.mkdirs();
        }

        final String errorBase = getScreenshotErrorBaseName();
        File[] files = errorDirectory.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                String thisFile = pathname.getAbsolutePath();
                if (thisFile.startsWith(errorBase)) {
                    return true;
                }
                return false;
            }
        });
        for (File f : files) {
            f.delete();
        }
    }
}
