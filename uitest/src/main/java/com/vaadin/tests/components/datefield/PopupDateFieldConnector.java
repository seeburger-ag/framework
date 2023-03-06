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
import com.vaadin.ui.PopupDateField;

public class PopupDateFieldConnector extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new PopupDateField());
        addComponent(new DateField());
    }

    @Override
    protected Integer getTicketNumber() {
        return 17090;
    }

    @Override
    protected String getTestDescription() {
        return "PopupDateFieldElement should be accessible using TB4 PopupDateFieldElement.";
    }
}
