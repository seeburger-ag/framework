/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class PushToggleComponentVisibilityTest extends SingleBrowserTest {

    private static final String HIDE = "hide";

    @Test
    public void ensureComponentVisible() {
        openTestURL();

        $(ButtonElement.class).id(HIDE).click();
        Assert.assertEquals("Please wait",
                $(LabelElement.class).first().getText());

        waitUntil(new ExpectedCondition<Object>() {
            @Override
            public Object apply(WebDriver driver) {
                return isElementPresent(ButtonElement.class);
            }
        });
        $(ButtonElement.class).id(HIDE).click();
        Assert.assertEquals("Please wait",
                $(LabelElement.class).first().getText());
    }
}
