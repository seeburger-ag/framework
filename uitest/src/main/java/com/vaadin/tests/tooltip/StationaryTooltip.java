/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tooltip;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class StationaryTooltip extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout vl = new VerticalLayout();
        Button button = new Button("Button");
        button.setDescription("description");

        button.setWidth("200px");
        vl.addComponent(button);

        addComponent(vl);
    }

    @Override
    protected String getTestDescription() {
        return null;
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }
}
