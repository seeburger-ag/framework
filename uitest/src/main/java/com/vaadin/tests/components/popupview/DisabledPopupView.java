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
import com.vaadin.ui.Button;
import com.vaadin.ui.PopupView;

public class DisabledPopupView extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        PopupView popupView = new PopupView("Disabled Popup",
                new Button("Hi!"));

        popupView.setEnabled(false);

        addComponent(popupView);
    }

    @Override
    protected Integer getTicketNumber() {
        return 14797;
    }
}
