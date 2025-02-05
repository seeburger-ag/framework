/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.flash;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.FlashElement;
import com.vaadin.testbench.parallel.Browser;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class FlashExpansionTest extends MultiBrowserTest {

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        return getBrowsersSupportingFlash();
    }

    private final By locator = By.tagName("embed");

    @Test
    public void testFlashIsExpanded() throws Exception {
        openTestURL();
        /* Allow the flash plugin to load */
        waitForElementPresent(locator);
        WebElement embed = $(FlashElement.class).first().findElement(locator);
        String width = embed.getAttribute("width");
        Assert.assertTrue("Width is not 400.0px initially",
                "400.0px".equals(width));
        $(ButtonElement.class).first().click();
        String widthAfterExpansion = embed.getAttribute("width");
        Assert.assertFalse("Width is still 400.0px after expansion",
                "400.0px".equals(widthAfterExpansion));
    }

    private List<DesiredCapabilities> getBrowsersSupportingFlash() {
        // No Flash support in Chrome, FF, PhantomJS
        return getBrowserCapabilities(Browser.IE8, Browser.IE9, Browser.IE10,
                Browser.IE11);
    }
}
