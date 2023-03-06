/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.PasswordFieldElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class ErrorInUnloadEventTest extends MultiBrowserTest {

    @Test
    public void testError() {
        openTestURL();
        TextFieldElement user = $(TextFieldElement.class).id("user");
        user.focus();
        user.sendKeys("a");
        PasswordFieldElement pass = $(PasswordFieldElement.class).id("pwd");
        pass.focus();
        pass.sendKeys("d");
        ButtonElement button = $(ButtonElement.class).id("loginButton");
        button.click();

        assertEquals("label is incorrect, error while loading page",
                "...Title...", $(LabelElement.class).first().getText());

        openTestURL();
        // no errors and page fully reloaded
        assertTrue($(LabelElement.class).all().isEmpty());
    }

}
