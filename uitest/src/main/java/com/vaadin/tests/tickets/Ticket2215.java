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
import com.vaadin.ui.Label;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

public class Ticket2215 extends LegacyApplication {

    @Override
    public void init() {
        setMainWindow(new LegacyWindow());

        VerticalLayout ol = new VerticalLayout();
        VerticalLayout pl = new VerticalLayout();
        pl.setMargin(true);
        Panel p = new Panel("Test", pl);
        pl.addComponent(new Label("Panel1"));
        p.setHeight("500px");
        p.setWidth("500px");
        p.setStyleName(Reindeer.PANEL_LIGHT);
        ol.addComponent(p);
        ol.addComponent(new Label("NextComponent"));

        getMainWindow().addComponent(ol);

    }

}
