/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;

@Theme("valo")
public class PopupDateField extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
        com.vaadin.ui.PopupDateField date = new com.vaadin.ui.PopupDateField();
        addComponent(date);
    }
}
