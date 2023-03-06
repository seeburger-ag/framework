/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class CssLayoutAbsoluteUrlTest extends SingleBrowserTest {
    @Test
    public void testAboutBlankStyle() {
        openTestURL();

        WebElement myLabel = findElement(By.id("myLabel"));

        String backgroundImage = myLabel.getCssValue("background-image");

        // Not testing string equality since some browsers return the style with
        // quotes around the url argument and some without quotes.
        Assert.assertTrue(backgroundImage + " does not contain 'about:blank'",
                backgroundImage.contains("about:blank"));
    }
}
