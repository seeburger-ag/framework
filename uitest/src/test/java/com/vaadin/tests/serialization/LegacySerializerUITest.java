/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.serialization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class LegacySerializerUITest extends SingleBrowserTest {

    @Test
    public void testInfinity() {
        openTestURL();
        WebElement html = findElement(By.className("gwt-HTML"));
        Assert.assertEquals("doubleInfinity: Infinity", html.getText());
        // Can't send infinity back, never have been able to
        Assert.assertEquals("1. doubleInfinity: null", getLogRow(0));
    }

}
