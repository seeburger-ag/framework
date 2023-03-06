/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.splitpanel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class SplitPanelMoveComponentTest extends MultiBrowserTest {

    private static final String BUTTON_TEXT = "Button in splitpanel. Click to move to the other side";

    @Test
    public void moveComponent() {
        openTestURL();
        Assert.assertEquals(BUTTON_TEXT, getFirstChild().getText());
        getFirstChild().click();
        Assert.assertEquals(BUTTON_TEXT, getSecondChild().getText());
        getSecondChild().click();
        Assert.assertEquals(BUTTON_TEXT, getFirstChild().getText());
    }

    private WebElement getFirstChild() {
        WebElement container = getDriver().findElement(By.xpath(
                "//div[contains(@class,'v-splitpanel-first-container')]"));
        return container
                .findElement(By.xpath("//div[contains(@class, 'v-button')]"));
    }

    private WebElement getSecondChild() {
        WebElement container = getDriver().findElement(By.xpath(
                "//div[contains(@class,'v-splitpanel-second-container')]"));
        return container
                .findElement(By.xpath("//div[contains(@class, 'v-button')]"));
    }

}
