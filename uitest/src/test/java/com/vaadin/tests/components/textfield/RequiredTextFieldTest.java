/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for .v-required style
 *
 * @author Vaadin Ltd
 */
public class RequiredTextFieldTest extends MultiBrowserTest {

    @Test
    public void testRequiredStyleName() {
        openTestURL();

        $(ButtonElement.class).first().click();

        Assert.assertTrue("Text field doesn't contain .v-required style",
                getStyles().contains("v-required"));

        $(ButtonElement.class).first().click();

        Assert.assertFalse(
                "Text field contains .v-required style for non-required field",
                getStyles().contains("v-required"));
    }

    private String getStyles() {
        return $(TextFieldElement.class).first().getAttribute("class");
    }

}
