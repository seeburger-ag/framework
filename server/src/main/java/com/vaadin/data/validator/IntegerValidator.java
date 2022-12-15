/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.validator;

import com.vaadin.data.Property;
import com.vaadin.data.util.converter.StringToIntegerConverter;

/**
 * String validator for integers. See {@link AbstractStringValidator} for more
 * information.
 *
 * @author Vaadin Ltd.
 * @since 5.4
 * @deprecated As of 7.0. Use a {@link StringToIntegerConverter} converter on
 *             the field instead or bind the field to a {@link Property} of type
 *             {@link Integer}.
 */
@SuppressWarnings("serial")
@Deprecated
public class IntegerValidator extends AbstractStringValidator {

    /**
     * Creates a validator for checking that a string can be parsed as an
     * integer.
     *
     * @param errorMessage
     *            the message to display in case the value does not validate.
     * @deprecated As of 7.0. Use an Integer converter on the field instead
     *             and/or use an {@link IntegerRangeValidator} for validating
     *             that the value is inside a given range.
     */
    @Deprecated
    public IntegerValidator(String errorMessage) {
        super(errorMessage);

    }

    @Override
    protected boolean isValidValue(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void validate(Object value) throws InvalidValueException {
        if (value != null && value instanceof Integer) {
            // Allow Integers to pass through the validator for easier
            // migration. Otherwise a TextField connected to an integer property
            // with an IntegerValidator will fail.
            return;
        }

        super.validate(value);
    }
}
