/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tooltip;

import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.TextField;

/**
 *
 * UI test class for Tooltip with integer range validator.
 */
public class ValidatorCaptionTooltip extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        TextField fieldWithError = new TextField();
        int min = 0;
        int max = 100;
        String errorMessage = "Valid value is between " + min + " and " + max
                + ". {0} is not.";
        IntegerRangeValidator validator = new IntegerRangeValidator(
                errorMessage, min, max);
        fieldWithError.setValue("142");

        fieldWithError.addValidator(validator);
        fieldWithError.setConverter(Integer.class);
        fieldWithError.setImmediate(true);

        TextField fieldWithoutError = new TextField();
        fieldWithoutError.addValidator(validator);
        fieldWithoutError.setConverter(Integer.class);
        fieldWithoutError.setValue("42");
        addComponent(fieldWithError);
        addComponent(fieldWithoutError);
    }

    @Override
    protected String getTestDescription() {
        return "Valid value is from 0 to 100.When the value is not valid. An error tooltip should appear";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14046;
    }

}
