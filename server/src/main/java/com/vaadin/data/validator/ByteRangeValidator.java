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
 * Validator for validating that an {@link Byte} is inside a given range.
 *
 * @author Vaadin Ltd.
 * @since 7.4
 */
@SuppressWarnings("serial")
public class ByteRangeValidator extends RangeValidator<Byte> {

    /**
     * Creates a validator for checking that an Byte is within a given range.
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
    public ByteRangeValidator(String errorMessage, Byte minValue,
            Byte maxValue) {
        super(errorMessage, Byte.class, minValue, maxValue);
    }

}
