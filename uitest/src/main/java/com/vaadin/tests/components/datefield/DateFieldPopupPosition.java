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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;

/**
 * Test UI for date field Popup calendar.
 *
 * @author Vaadin Ltd
 */
public abstract class DateFieldPopupPosition extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        HorizontalLayout layout = new HorizontalLayout();
        addComponent(layout);
        Label gap = new Label();
        gap.setWidth(250, Unit.PIXELS);
        layout.addComponent(gap);
        PopupDateField field = new PopupDateField();
        layout.addComponent(field);
    }

    @Override
    protected Integer getTicketNumber() {
        return 14757;
    }

    @Override
    protected String getTestDescription() {
        return "Calendar popup should not placed on the top of text field when "
                + "there is no space on bottom.";
    }
}
