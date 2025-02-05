/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.parallel.BrowserUtil;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class VerifyBrowserVersionTest extends MultiBrowserTest {

    @Test
    public void verifyUserAgent() {
        openTestURL();

        DesiredCapabilities desiredCapabilities = getDesiredCapabilities();

        String userAgent = vaadinElementById("userAgent").getText();
        String browserIdentifier;

        if (BrowserUtil.isChrome(getDesiredCapabilities())) {
            // Chrome version does not necessarily match the desired version
            // because of auto updates...
            browserIdentifier = getExpectedUserAgentString(
                    getDesiredCapabilities()) + "107";
        } else {
            browserIdentifier = getExpectedUserAgentString(desiredCapabilities)
                    + desiredCapabilities.getVersion();
        }

        assertThat(userAgent, containsString(browserIdentifier));

        assertThat(vaadinElementById("touchDevice").getText(),
                is("Touch device? No"));
    }

    private String getExpectedUserAgentString(DesiredCapabilities dCap) {
        if (BrowserUtil.isIE(dCap)) {
            if (!BrowserUtil.isIE(dCap, 11)) {
                // IE8-10
                return "MSIE ";
            } else {
                // IE11
                return "Trident/7.0; rv:";
            }
        } else if (BrowserUtil.isFirefox(dCap)) {
            return "Firefox/";
        } else if (BrowserUtil.isChrome(dCap)) {
            return "Chrome/";
        } else if (BrowserUtil.isPhantomJS(dCap)) {
            return "PhantomJS/";
        }
        throw new UnsupportedOperationException(
                "Test is being run on unknown browser.");
    }

}
