/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests that a text field's value isn't cleared after a label in the same
 * layout is changed.
 *
 * @since 7.3
 * @author Vaadin Ltd
 */
public class TextFieldValueGoesMissingTest extends MultiBrowserTest {

    /* This test was rewritten from a TB2 test. */
    @Test
    public void valueMissingTest() throws Exception {
        openTestURL();

        waitForElementVisible(By.className("v-textfield"));

        TextFieldElement textfield = $(TextFieldElement.class).first();
        textfield.focus();
        textfield.sendKeys("test");

        $(ButtonElement.class).first().click();

        new Actions(getDriver()).contextClick(textfield).perform();

        Assert.assertEquals("test", textfield.getValue());
    }
}
