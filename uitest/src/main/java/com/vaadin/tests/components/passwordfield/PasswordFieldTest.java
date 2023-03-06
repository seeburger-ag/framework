/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.passwordfield;

import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.tests.components.abstractfield.AbstractTextFieldTest;
import com.vaadin.ui.PasswordField;

public class PasswordFieldTest extends AbstractTextFieldTest<PasswordField>
        implements TextChangeListener {

    @Override
    protected Class<PasswordField> getTestClass() {
        return PasswordField.class;
    }

    @Override
    protected void createActions() {
        super.createActions();
    }

}
