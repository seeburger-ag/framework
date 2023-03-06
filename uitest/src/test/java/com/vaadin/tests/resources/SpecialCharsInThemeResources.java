/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.resources;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class SpecialCharsInThemeResources extends SingleBrowserTest {

    @Test
    public void loadThemeResource() {
        loadResource("/VAADIN/themes/tests-tickets/ordinary.txt");
        checkSource();
    }

    @Test
    public void loadThemeResourceWithPercentage() {
        loadResource("/VAADIN/themes/tests-tickets/percentagein%2520name.txt");
        checkSource();
    }

    @Test
    public void loadThemeResourceWithSpecialChars() {
        loadResource(
                "/VAADIN/themes/tests-tickets/folder%20with%20space/resource%20with%20special%20$chars@.txt");
        checkSource();
    }

    private void loadResource(String path) {
        getDriver().get(getBaseURL() + path);
    }

    private void checkSource() {
        String source = getDriver().getPageSource();
        Assert.assertTrue("Incorrect contents (was: " + source + ")",
                source.contains("Just ordinary contents here"));
    }
}
