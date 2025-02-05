/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.form;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.ui.Form;
import com.vaadin.ui.TextField;

/**
 * Test for {@link Form}.
 *
 * @author Vaadin Ltd
 */
public class FormTest {

    @Test
    public void testFocus() {
        Form form = new Form();
        final boolean firstFieldIsFocused[] = new boolean[1];
        TextField field1 = new TextField() {
            @Override
            public boolean isConnectorEnabled() {
                return false;
            }

            @Override
            public void focus() {
                firstFieldIsFocused[0] = true;
            }
        };

        final boolean secondFieldIsFocused[] = new boolean[1];
        TextField field2 = new TextField() {
            @Override
            public boolean isConnectorEnabled() {
                return true;
            }

            @Override
            public void focus() {
                secondFieldIsFocused[0] = true;
            }
        };
        form.addField("a", field1);
        form.addField("b", field2);
        form.focus();

        Assert.assertTrue("Field with enabled connector is not focused",
                secondFieldIsFocused[0]);
        Assert.assertFalse("Field with disabled connector is focused",
                firstFieldIsFocused[0]);
    }
}
