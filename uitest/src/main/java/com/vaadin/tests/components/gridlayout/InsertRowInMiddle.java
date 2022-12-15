/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.gridlayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class InsertRowInMiddle extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final GridLayout layout = new GridLayout(1, 2);
        layout.addComponent(new Label("some row"), 0, 0);
        Button newRowButton = new Button("Insert Row");
        newRowButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.insertRow(1);
                layout.addComponent(new Label("some new row"), 0, 1);
            }
        });
        layout.addComponent(newRowButton, 0, 1);
        addComponent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "A new row added to the middle of a GridLayout should appear without any exception being thrown.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(10097);
    }

}
