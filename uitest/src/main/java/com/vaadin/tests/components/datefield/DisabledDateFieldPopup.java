/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.DateField;

public class DisabledDateFieldPopup extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        DateField field = new DateField();
        field.setEnabled(false);
        addComponent(field);
    }

    @Override
    protected String getTestDescription() {
        return "Don't open popup calendar if datefield is disabled";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13508;
    }

}
