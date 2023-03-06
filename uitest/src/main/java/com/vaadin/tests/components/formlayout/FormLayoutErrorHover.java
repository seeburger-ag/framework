/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.formlayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PopupDateField;

public class FormLayoutErrorHover extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        FormLayout formLayout = new FormLayout();
        PopupDateField fromDate = new PopupDateField("Date");
        fromDate.setImmediate(true);
        formLayout.addComponent(fromDate);

        addComponent(formLayout);
    }

    @Override
    protected String getTestDescription() {
        return "Enter some random text to the date field and press enter. Then hover the error indicator. This should show a message about the error.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(8794);
    }

}
