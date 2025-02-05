/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.validator;

/**
 * Validator for validating that an {@link Integer} is inside a given range.
 *
 * @author Vaadin Ltd.
 * @since 5.4
 */
@SuppressWarnings("serial")
public class IntegerRangeValidator extends RangeValidator<Integer> {

    /**
     * Creates a validator for checking that an Integer is within a given range.
     *
     * By default the range is inclusive i.e. both minValue and maxValue are
     * valid values. Use {@link #setMinValueIncluded(boolean)} or
     * {@link #setMaxValueIncluded(boolean)} to change it.
     *
     *
     * @param errorMessage
     *            the message to display in case the value does not validate.
     * @param minValue
     *            The minimum value to accept or null for no limit
     * @param maxValue
     *            The maximum value to accept or null for no limit
     */
    public IntegerRangeValidator(String errorMessage, Integer minValue,
            Integer maxValue) {
        super(errorMessage, Integer.class, minValue, maxValue);
    }

}
