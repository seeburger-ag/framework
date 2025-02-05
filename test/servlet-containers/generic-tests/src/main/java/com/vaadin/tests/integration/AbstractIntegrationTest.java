/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.integration;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.google.common.base.Predicate;
import com.vaadin.testbench.By;
import org.junit.After;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.vaadin.testbench.annotations.RunLocally;
import com.vaadin.testbench.elements.UIElement;
import com.vaadin.testbench.parallel.Browser;
import com.vaadin.testbench.parallel.ParallelRunner;
import com.vaadin.testbench.parallel.ParallelTest;
import com.vaadin.testbench.parallel.TestNameSuffix;
import com.vaadin.testbench.screenshot.ImageFileUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunLocally(Browser.PHANTOMJS)
@RunWith(ParallelRunner.class)
@TestNameSuffix(property = "server-name")
public abstract class AbstractIntegrationTest extends ParallelTest {

    /**
     * Height of the screenshots we want to capture
     */
    private static final int SCREENSHOT_HEIGHT = 850;

    /**
     * Width of the screenshots we want to capture
     */
    private static final int SCREENSHOT_WIDTH = 1500;

    private boolean screenshotErrors;

    @Override
    public void setup() throws Exception {
        super.setup();

        testBench().resizeViewPortTo(SCREENSHOT_WIDTH, SCREENSHOT_HEIGHT);

        openTestURL(getParameters());
    }

    protected void openTestURL(String[] parameters) {
        StringBuilder builder = new StringBuilder();
        builder.append(getDeploymentURL()).append(getContextPath()).append(getTestPath());
        builder.append("?");
        for (int i = 0; i < parameters.length; ++i) {
            builder.append(parameters[i]);
            if (i < parameters.length - 1) {
                builder.append("&");
            }
        }

        driver.get(builder.toString());

        if (!isElementPresent(UIElement.class)) {
            waitUntil(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver webDriver) {
                    return isElementPresent(UIElement.class);
                }
            });
        }
    }

    protected String[] getParameters() {
        return new String[]{ "restartApplication" };
    }

    /**
     * Returns a path where the test UI is found.
     *
     * @return path for test
     */
    protected abstract String getTestPath();

    private String getDeploymentURL() {
        String deploymentUrl = System.getProperty("deployment.url");
        if (deploymentUrl == null || deploymentUrl.isEmpty()) {
            // Default to http://localhost:8080
            return "http://localhost:8080";
        }
        return deploymentUrl;
    }

    protected void compareScreen(String identifier) throws IOException {
        String refFileName = identifier + "-"
                + getDesiredCapabilities().getBrowserName().toLowerCase(Locale.ROOT)
                + ".png";
        String errorFileName = identifier + "-"
                + getDesiredCapabilities().getBrowserName().toLowerCase(Locale.ROOT) + "-"
                + System.getProperty("server-name") + "["
                + getClass().getSimpleName() + "].png";
        File referenceFile = ImageFileUtil
                .getReferenceScreenshotFile(refFileName);
        try {
            BufferedImage reference = ImageIO.read(referenceFile);
            if (testBench().compareScreen(reference, errorFileName)) {
                return;
            }
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).warning(
                    "Missing screenshot reference: " + referenceFile.getPath());
        }
        screenshotErrors = true;
    }

    @After
    public void teardown() {
        if (screenshotErrors) {
            throw new RuntimeException("Screenshots failed.");
        }
    }

    /**
     * Returns the deployment context path with a leading slash. If not provided
     * through {@code deployment.context.path} system property, will default to
     * {@code /demo}.
     *
     * @return deployment context path
     */
    protected String getContextPath() {
        String contextPath = System.getProperty("deployment.context.path");
        if (contextPath == null || contextPath.isEmpty()) {
            // Default to /demo
            return "/demo";
        }
        return contextPath;
    }

    protected void waitUntil(ExpectedCondition<Boolean> condition) {
        new WebDriverWait(driver, 10).until(condition);
    }
}
