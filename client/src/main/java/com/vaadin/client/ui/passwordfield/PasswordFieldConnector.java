/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.passwordfield;

import com.vaadin.client.ui.VPasswordField;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.PasswordField;

@Connect(PasswordField.class)
public class PasswordFieldConnector extends TextFieldConnector {

    @Override
    public VPasswordField getWidget() {
        return (VPasswordField) super.getWidget();
    }
}
