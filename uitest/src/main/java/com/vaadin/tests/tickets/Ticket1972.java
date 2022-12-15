/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.server.LegacyApplication;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.LegacyWindow;

public class Ticket1972 extends LegacyApplication {

    @Override
    public void init() {
        LegacyWindow w = new LegacyWindow(getClass().getName());
        setMainWindow(w);
        setTheme("tests-ticket");
        GridLayout layout = new GridLayout(3, 3);
        layout.setStyleName("borders");
        layout.addComponent(new Label("1-1"));
        layout.space();
        layout.space();
        layout.addComponent(new Label("2-1"));
        layout.space();
        layout.space();
        layout.addComponent(new Label("3-1"));
        layout.space();
        layout.addComponent(new Label("3-3"));

        w.setContent(layout);
    }

}
