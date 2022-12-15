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
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class Ticket1940 extends LegacyApplication {

    @Override
    public void init() {
        final LegacyWindow w = new LegacyWindow(getClass().getName());
        setMainWindow(w);

        final VerticalLayout l = new VerticalLayout();
        l.setWidth("200px");
        l.setHeight(null);
        TextField t = new TextField();
        l.addComponent(t);
        t.setRequired(true);
        w.addComponent(l);

    }

}
