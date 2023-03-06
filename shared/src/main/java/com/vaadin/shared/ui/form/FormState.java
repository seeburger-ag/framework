/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.form;

import com.vaadin.shared.AbstractFieldState;
import com.vaadin.shared.Connector;

public class FormState extends AbstractFieldState {
    {
        primaryStyleName = "v-form";
    }
    public Connector layout;
    public Connector footer;
}
