/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.user.client.DOM;

/**
 * This class represents a password field.
 *
 * @author Vaadin Ltd.
 *
 */
public class VPasswordField extends VTextField {

    public VPasswordField() {
        super(DOM.createInputPassword());
    }

}
