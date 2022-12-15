/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.NullValidator;

public class NullValidatorTest {

    NullValidator notNull = new NullValidator("Null not accepted", false);
    NullValidator onlyNull = new NullValidator("Only null accepted", true);

    @Test
    public void testNullValue() {
        try {
            notNull.validate(null);
            fail("expected null to fail with an exception");
        } catch (Validator.InvalidValueException ex) {
            assertEquals("Null not accepted", ex.getMessage());
        }
        try {
            onlyNull.validate(null);
        } catch (Validator.InvalidValueException ex) {
            fail("onlyNull should not throw exception for null");
        }
    }

    @Test
    public void testNonNullValue() {
        try {
            onlyNull.validate("Not a null value");
            fail("expected onlyNull validator to fail with an exception");
        } catch (Validator.InvalidValueException ex) {
            assertEquals("Only null accepted", ex.getMessage());
        }
        try {
            notNull.validate("Not a null value");
        } catch (Validator.InvalidValueException ex) {
            fail("notNull should not throw exception for \"Not a null value\"");
        }
    }
}
