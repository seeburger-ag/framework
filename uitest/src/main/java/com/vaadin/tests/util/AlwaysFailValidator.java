/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.util;

import com.vaadin.data.validator.AbstractValidator;

public class AlwaysFailValidator extends AbstractValidator<Object> {
    public AlwaysFailValidator() {
        super("Validation error");
    }

    public AlwaysFailValidator(String message) {
        super(message);
    }

    @Override
    protected boolean isValidValue(Object value) {
        return false;
    }

    @Override
    public Class getType() {
        return Object.class;
    }
}
