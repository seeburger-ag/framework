/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tooltip;

import org.junit.Test;

import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.TooltipTest;

/**
 * Test to see if validators create error tooltips correctly.
 *
 * @author Vaadin Ltd
 */
public class ValidatorCaptionTooltipTest extends TooltipTest {
    @Test
    public void validatorWithError() throws Exception {
        openTestURL();

        TextFieldElement field = $(TextFieldElement.class).get(0);
        String fieldValue = field.getAttribute("value");
        String expected = "Valid value is between 0 and 100. " + fieldValue
                + " is not.";
        checkTooltip(field, expected);
    }

    @Test
    public void validatorWithoutError() throws Exception {
        openTestURL();
        TextFieldElement field = $(TextFieldElement.class).get(1);
        checkTooltip(field, null);
    }
}
