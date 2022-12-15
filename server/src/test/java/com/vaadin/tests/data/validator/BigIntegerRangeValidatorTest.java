/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.validator;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.data.validator.BigIntegerRangeValidator;

public class BigIntegerRangeValidatorTest {

    private BigIntegerRangeValidator cleanValidator = new BigIntegerRangeValidator(
            "no values", null, null);
    private BigIntegerRangeValidator minValidator = new BigIntegerRangeValidator(
            "no values", BigInteger.valueOf(10), null);
    private BigIntegerRangeValidator maxValidator = new BigIntegerRangeValidator(
            "no values", null, BigInteger.valueOf(100));
    private BigIntegerRangeValidator minMaxValidator = new BigIntegerRangeValidator(
            "no values", BigInteger.valueOf(10), BigInteger.valueOf(100));

    @Test
    public void testNullValue() {
        Assert.assertTrue("Didn't accept null", cleanValidator.isValid(null));
        Assert.assertTrue("Didn't accept null", minValidator.isValid(null));
        Assert.assertTrue("Didn't accept null", maxValidator.isValid(null));
        Assert.assertTrue("Didn't accept null", minMaxValidator.isValid(null));
    }

    @Test
    public void testMinValue() {
        Assert.assertTrue("Validator without ranges didn't accept value",
                cleanValidator.isValid(BigInteger.valueOf(-15)));
        Assert.assertTrue("Didn't accept valid value",
                minValidator.isValid(BigInteger.valueOf(15)));
        Assert.assertFalse("Accepted too small value",
                minValidator.isValid(BigInteger.valueOf(9)));
    }

    @Test
    public void testMaxValue() {
        Assert.assertTrue("Validator without ranges didn't accept value",
                cleanValidator.isValid(BigInteger.valueOf(1120)));
        Assert.assertTrue("Didn't accept valid value",
                maxValidator.isValid(BigInteger.valueOf(15)));
        Assert.assertFalse("Accepted too large value",
                maxValidator.isValid(BigInteger.valueOf(120)));
    }

    @Test
    public void testMinMaxValue() {
        Assert.assertTrue("Didn't accept valid value",
                minMaxValidator.isValid(BigInteger.valueOf(15)));
        Assert.assertTrue("Didn't accept valid value",
                minMaxValidator.isValid(BigInteger.valueOf(99)));
        Assert.assertFalse("Accepted too small value",
                minMaxValidator.isValid(BigInteger.valueOf(9)));
        Assert.assertFalse("Accepted too large value",
                minMaxValidator.isValid(BigInteger.valueOf(110)));
    }
}
