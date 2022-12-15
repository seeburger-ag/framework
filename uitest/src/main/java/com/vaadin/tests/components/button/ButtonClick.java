/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.button;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ButtonClick extends AbstractTestUI {

    public final static String SUCCESS_TEXT = "Click received succesfully!";
    public final static String WRONG_BUTTON_TEXT = "Wrong button clicked.";

    @Override
    protected void setup(VaadinRequest request) {
        final VerticalLayout rootLayout = new VerticalLayout();
        final Label statusLabel = new Label("Test initialized");
        rootLayout.addComponent(new Button("Click here", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                statusLabel.setValue(SUCCESS_TEXT);
            }

        }));
        Button visitLocation = new Button("Drag here", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                statusLabel.setValue(WRONG_BUTTON_TEXT);
            }

        });
        rootLayout.addComponent(statusLabel);
        rootLayout.addComponent(visitLocation);
        rootLayout.setComponentAlignment(visitLocation, Alignment.BOTTOM_RIGHT);
        rootLayout.setSizeFull();
        rootLayout.setMargin(true);
        setContent(rootLayout);
    }

    @Override
    protected String getTestDescription() {
        return "Verify button click logic";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13550;
    }

}
