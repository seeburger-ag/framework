/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.validation;

import org.junit.Test;

import com.vaadin.data.validator.IntegerValidator;
import com.vaadin.ui.TextField;

public class ReadOnlyValidationTest {

    @Test
    public void testIntegerValidation() {
        TextField field = new TextField();
        field.addValidator(new IntegerValidator("Enter a Valid Number"));
        field.setValue(String.valueOf(10));
        field.validate();
    }
}
