/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.formlayout;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class HtmlCaptionInFormLayoutTest extends SingleBrowserTest {
    @Test
    public void testHtmlCaptions() {
        openTestURL();

        List<WebElement> captions = getDriver()
                .findElements(By.cssSelector(".v-formlayout-captioncell span"));

        Assert.assertEquals("Should be two formlayout captions", 2,
                captions.size());

        Assert.assertEquals("Contains HTML", captions.get(0).getText());
        Assert.assertEquals("Contains <b>HTML</b>", captions.get(1).getText());
    }

    @Test
    public void testHtmlCaptionToggle() {
        openTestURL();

        $(ButtonElement.class).caption("Toggle").first().click();

        List<WebElement> captions = getDriver()
                .findElements(By.cssSelector(".v-formlayout-captioncell span"));

        Assert.assertEquals("Should be two formlayout captions", 2,
                captions.size());

        Assert.assertEquals("Contains <b>HTML</b>", captions.get(0).getText());
        Assert.assertEquals("Contains HTML", captions.get(1).getText());
    }

}
