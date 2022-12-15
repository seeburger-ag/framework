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
import com.vaadin.ui.VerticalLayout;

public class AriaDisabled extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        content.setMargin(true);
        content.setSpacing(true);

        final DateField disabledDateField = new DateField("Disabled DateField");
        disabledDateField.setEnabled(false);

        setContent(content);
        content.addComponent(disabledDateField);
        content.addComponent(new DateField("Enabled DateField"));
    }

    @Override
    protected String getTestDescription() {
        return "Test for aria-disabled attribute on DateField.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13463;
    }
}
