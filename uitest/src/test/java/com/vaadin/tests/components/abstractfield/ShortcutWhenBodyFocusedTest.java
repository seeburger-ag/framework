/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.abstractfield;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class ShortcutWhenBodyFocusedTest extends SingleBrowserTest {

    @Test
    public void triggerShortcutOnBody() {
        openTestURL();
        ButtonElement b = $(ButtonElement.class).caption("Hello").first();
        b.click();
        Assert.assertEquals("1. Hello clicked", getLogRow(0));

        b.sendKeys("a");
        Assert.assertEquals("2. Hello clicked", getLogRow(0));

        WebElement body = findElement(By.xpath("//body"));
        body.sendKeys("a");
        Assert.assertEquals("3. Hello clicked", getLogRow(0));
    }
}
