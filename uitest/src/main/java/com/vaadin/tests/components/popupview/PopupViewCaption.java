/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;

/**
 *
 * @author Vaadin Ltd
 */
public class PopupViewCaption extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        FormLayout layout = new FormLayout();
        addComponent(layout);
        Label label = new Label("Label");
        PopupView popup = new PopupView("Popup short text", label);
        popup.setCaption("Popup Caption:");
        layout.addComponent(popup);
    }

    @Override
    protected String getTestDescription() {
        return "Caption for popup view should be shown by layout";
    }

    @Override
    protected Integer getTicketNumber() {
        return 10618;
    }

}
