/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.javascriptcomponent;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class JavaScriptNoLayoutHandlingUITest extends MultiBrowserTest {

    @Test
    public void stateUpdate() {
        openTestURL("debug");
        WebElement js = findElement(By.id("js"));
        Assert.assertEquals("state: 1", js.getText());
        $(ButtonElement.class).first().click();

        Assert.assertEquals("state: 2", js.getText());
    }
}
