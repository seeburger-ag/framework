/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared;

import java.io.Serializable;

public class Version implements Serializable {
    /**
     * The version number of this release. For example "6.2.0". Always in the
     * format "major.minor.revision[.build]". The build part is optional. All of
     * major, minor, revision must be integers.
     */
    private static final String VERSION;
    /**
     * Major version number. For example 6 in 6.2.0.
     */
    private static final int VERSION_MAJOR;

    /**
     * Minor version number. For example 2 in 6.2.0.
     */
    private static final int VERSION_MINOR;

    /**
     * Version revision number. For example 0 in 6.2.0.
     */
    private static final int VERSION_REVISION;

    /**
     * Build identifier. For example "nightly-20091123-c9963" in
     * 6.2.0.nightly-20091123-c9963.
     */
    private static final String VERSION_BUILD;

    /* Initialize version numbers from string replaced by build-script. */
    static {
        if ("${project.version}".equals("${" + "project.version" + "}")) {
            VERSION = "9.9.9.INTERNAL-DEBUG-BUILD";
        } else {
            VERSION = "${project.version}";
        }
        final String[] digits = VERSION.split("[-.]", 4);
        VERSION_MAJOR = Integer.parseInt(digits[0]);
        VERSION_MINOR = Integer.parseInt(digits[1]);

        int revision;
        try {
            revision = Integer.parseInt(digits[2]);
        } catch (NumberFormatException e) {
            revision = 0;
        }
        VERSION_REVISION = revision;

        if (digits.length == 4) {
            VERSION_BUILD = digits[3];
        } else {
            VERSION_BUILD = "";
        }
    }

    public static String getFullVersion() {
        return VERSION;
    }

    public static int getMajorVersion() {
        return VERSION_MAJOR;
    }

    public static int getMinorVersion() {
        return VERSION_MINOR;
    }

    public static int getRevision() {
        return VERSION_REVISION;
    }

    public static String getBuildIdentifier() {
        return VERSION_BUILD;
    }

}
