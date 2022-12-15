/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.form;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.FormElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.TooltipTest;

public class FormTooltipsTest extends TooltipTest {

    @Test
    public void testTooltipConfiguration() throws Exception {
        openTestURL();
        // first name tooltip

        WebElement fieldElement = $(FormElement.class).first()
                .$(TextFieldElement.class).first();
        checkTooltip(fieldElement, "Fields own tooltip");
        clearTooltip();
        checkTooltipNotPresent();

        // first name caption tooltip
        checkTooltip($(FormElement.class).first()
                .findElement(By.className("v-caption")), "Fields own tooltip");

        clearTooltip();
        checkTooltipNotPresent();

        // Form should not have a description tooltip
        checkTooltip($(FormElement.class).first(), null);

        // Form error message should not have a tooltip
        checkTooltip(By.className("v-form-errormessage"), null);

        // last name should have no tooltip
        checkTooltip($(TextFieldElement.class).get(1), null);

        // last name caption should have no tooltip
        checkTooltip($(FormElement.class).first()
                .findElements(By.className("v-caption")).get(1), null);
    }

}