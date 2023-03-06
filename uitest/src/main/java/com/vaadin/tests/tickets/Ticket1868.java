/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class Ticket1868 extends com.vaadin.server.LegacyApplication {

    @Override
    public void init() {

        setMainWindow(new LegacyWindow("#1868"));

        VerticalLayout pl = new VerticalLayout();
        pl.setMargin(true);
        Panel p = new Panel(
                "This is a really long caption for the panel, too long in fact!",
                pl);
        p.setWidth("300px");
        p.setHeight("300px");

        getMainWindow().addComponent(p);
    }
}
