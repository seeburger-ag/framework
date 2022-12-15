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
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class TooltipInWindow extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        Window window = new Window("Window", layout);
        layout.setSizeUndefined();
        window.center();
        layout.addComponent(createTextField("tf1"));

        addWindow(window);
        addComponent(createTextField("tf2"));
    }

    private TextField createTextField(String id) {
        TextField tf = new TextField("TextField with a tooltip");
        tf.setDescription("My tooltip");
        tf.setId(id);
        return tf;
    }

    @Override
    protected String getTestDescription() {
        return "Tooltips should also work in a Window (as well as in other overlays)";
    }

    @Override
    protected Integer getTicketNumber() {
        return 9172;
    }

}
