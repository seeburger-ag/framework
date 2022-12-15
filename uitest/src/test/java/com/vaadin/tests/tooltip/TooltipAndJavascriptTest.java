/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tooltip;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class TooltipAndJavascriptTest extends MultiBrowserTest {

    @Test
    public void ensureTooltipInOverlay() throws InterruptedException {
        openTestURL();
        $(ButtonElement.class).first().showTooltip();
        WebElement tooltip = findElement(
                By.cssSelector(".v-overlay-container .v-tooltip"));
        WebElement overlayContainer = getParent(tooltip);
        Assert.assertTrue("v-overlay-container did not receive theme",
                hasClass(overlayContainer, "reindeer"));
    }

    private boolean hasClass(WebElement element, String classname) {
        String[] classes = element.getAttribute("class").split(" ");
        for (String classString : classes) {
            if (classname.equals(classString)) {
                return true;
            }
        }
        return false;
    }

    private WebElement getParent(WebElement element) {
        return (WebElement) ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].parentNode;", element);
    }
}
