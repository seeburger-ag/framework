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

import com.vaadin.data.validator.IntegerRangeValidator;

public class IntegerRangeValidatorTest {

    private IntegerRangeValidator cleanValidator = new IntegerRangeValidator(
            "no values", null, null);
    private IntegerRangeValidator minValidator = new IntegerRangeValidator(
            "no values", 10, null);
    private IntegerRangeValidator maxValidator = new IntegerRangeValidator(
            "no values", null, 100);
    private IntegerRangeValidator minMaxValidator = new IntegerRangeValidator(
            "no values", 10, 100);

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
                cleanValidator.isValid(-15));
        assertTrue("Didn't accept valid value", minValidator.isValid(15));
        assertFalse("Accepted too small value", minValidator.isValid(9));
    }

    @Test
    public void testMaxValue() {
        assertTrue("Validator without ranges didn't accept value",
                cleanValidator.isValid(1120));
        assertTrue("Didn't accept valid value", maxValidator.isValid(15));
        assertFalse("Accepted too large value", maxValidator.isValid(120));
    }

    @Test
    public void testMinMaxValue() {
        assertTrue("Didn't accept valid value", minMaxValidator.isValid(15));
        assertTrue("Didn't accept valid value", minMaxValidator.isValid(99));
        assertFalse("Accepted too small value", minMaxValidator.isValid(9));
        assertFalse("Accepted too large value", minMaxValidator.isValid(110));
    }
}
