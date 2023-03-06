/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.loginform;

import com.google.gwt.user.client.ui.FormPanel;

public class VLoginForm extends FormPanel {

    public VLoginForm() {
        getElement().setId("loginForm");
        setMethod(METHOD_POST);
    }
}
