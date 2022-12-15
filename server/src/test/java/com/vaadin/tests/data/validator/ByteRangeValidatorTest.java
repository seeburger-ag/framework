/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.vaadin.data.validator.ByteRangeValidator;

public class ByteRangeValidatorTest {

    private ByteRangeValidator cleanValidator = new ByteRangeValidator(
            "no values", null, null);
    private ByteRangeValidator minValidator = new ByteRangeValidator(
            "no values", (byte) 10, null);
    private ByteRangeValidator maxValidator = new ByteRangeValidator(
            "no values", null, (byte) 100);
    private ByteRangeValidator minMaxValidator = new ByteRangeValidator(
            "no values", (byte) 10, (byte) 100);

    @Test
    public void testNullValue() {
        assertTrue("Didn't accept null", cleanValidator.isValid(null));
        assertTrue("Didn't accept null", minValidator.isValid(null));
        assertTrue("Didn't accept null", maxValidator.isValid(null));
        assertTrue("Didn't accept null", minMaxValidator.isValid(null));
    }

    @Test
    public void testMinValue() {
        assertTrue("Validator without ranges didn't accept value",
                cleanValidator.isValid((byte) -15));
        assertTrue("Didn't accept valid value",
                minValidator.isValid((byte) 15));
        assertFalse("Accepted too small value", minValidator.isValid((byte) 9));
    }

    @Test
    public void testMaxValue() {
        assertTrue("Validator without ranges didn't accept value",
                cleanValidator.isValid((byte) 112));
        assertTrue("Didn't accept valid value",
                maxValidator.isValid((byte) 15));
        assertFalse("Accepted too large value",
                maxValidator.isValid((byte) 120));
    }

    @Test
    public void testMinMaxValue() {
        assertTrue("Didn't accept valid value",
                minMaxValidator.isValid((byte) 15));
        assertTrue("Didn't accept valid value",
                minMaxValidator.isValid((byte) 99));
        assertFalse("Accepted too small value",
                minMaxValidator.isValid((byte) 9));
        assertFalse("Accepted too large value",
                minMaxValidator.isValid((byte) 110));
    }
}
