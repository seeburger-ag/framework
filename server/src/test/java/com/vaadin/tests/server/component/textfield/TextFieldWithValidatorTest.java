/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.textfield;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.TextField;

public class TextFieldWithValidatorTest {

    private TextField field;
    private ObjectProperty<String> property;

    @Before
    public void setUp() {

        field = new TextField();
        field.setInvalidAllowed(false);
        property = new ObjectProperty<String>("original");
        field.setPropertyDataSource(property);
    }

    @Test
    public void testMultipleValidators() {
        field.addValidator(new StringLengthValidator(
                "Length not between 1 and 3", 1, 3, false));
        field.addValidator(new StringLengthValidator(
                "Length not between 2 and 4", 2, 4, false));

        // fails
        try {
            field.setValue("a");
            fail();
        } catch (InvalidValueException e) {
            // should fail
        }
        // succeeds
        field.setValue("ab");
        // fails
        try {
            field.setValue("abcd");
            fail();
        } catch (InvalidValueException e) {
            // should fail
        }
    }

    @Test
    public void testRemoveValidator() {
        Validator validator1 = new StringLengthValidator(
                "Length not between 1 and 3", 1, 3, false);
        Validator validator2 = new StringLengthValidator(
                "Length not between 2 and 4", 2, 4, false);

        field.addValidator(validator1);
        field.addValidator(validator2);
        field.removeValidator(validator1);

        // fails
        try {
            field.setValue("a");
            fail();
        } catch (InvalidValueException e) {
            // should fail
        }
        // succeeds
        field.setValue("ab");
        // succeeds
        field.setValue("abcd");
    }

    @Test
    public void testRemoveAllValidators() {
        Validator validator1 = new StringLengthValidator(
                "Length not between 1 and 3", 1, 3, false);
        Validator validator2 = new StringLengthValidator(
                "Length not between 2 and 4", 2, 4, false);

        field.addValidator(validator1);
        field.addValidator(validator2);
        field.removeAllValidators();

        // all should succeed now
        field.setValue("a");
        field.setValue("ab");
        field.setValue("abcd");
    }

    @Test
    public void testEmailValidator() {
        field.addValidator(new EmailValidator("Invalid e-mail address"));

        // not required

        field.setRequired(false);
        // succeeds
        field.setValue("");
        // needed as required flag not checked by setValue()
        field.validate();
        // succeeds
        field.setValue(null);
        // needed as required flag not checked by setValue()
        field.validate();
        // succeeds
        field.setValue("test@example.com");
        // fails
        try {
            field.setValue("invalid e-mail");
            fail();
        } catch (InvalidValueException e) {
            // should fail
        }

        // required

        field.setRequired(true);
        // fails
        try {
            field.setValue("");
            // needed as required flag not checked by setValue()
            field.validate();
            fail();
        } catch (InvalidValueException e) {
            // should fail
        }
        // fails
        try {
            field.setValue(null);
            // needed as required flag not checked by setValue()
            field.validate();
            fail();
        } catch (InvalidValueException e) {
            // should fail
        }
        // succeeds
        field.setValue("test@example.com");
        // fails
        try {
            field.setValue("invalid e-mail");
            fail();
        } catch (InvalidValueException e) {
            // should fail
        }
    }

    @Test
    public void testRegexpValidator() {
        field.addValidator(
                new RegexpValidator("pattern", true, "Validation failed"));
        field.setRequired(false);

        // succeeds
        field.setValue("");
        // needed as required flag not checked by setValue()
        field.validate();
        // succeeds
        field.setValue(null);
        // needed as required flag not checked by setValue()
        field.validate();
        // succeeds
        field.setValue("pattern");

        // fails
        try {
            field.setValue("mismatch");
            fail();
        } catch (InvalidValueException e) {
            // should fail
        }
    }

}
