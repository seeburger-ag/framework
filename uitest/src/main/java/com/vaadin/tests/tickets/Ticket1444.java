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
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.VerticalLayout;

public class Ticket1444 extends LegacyApplication {

    @Override
    public void init() {

        final LegacyWindow mainWin = new LegacyWindow(
                "Test app to break layout fuction in IE7");
        setMainWindow(mainWin);

        VerticalLayout ol = new VerticalLayout();
        ol.setHeight("250px");
        ol.setWidth("500px");

        Label red = new Label(
                "<div style='background:red;width:100%;height:100%;'>??</div>",
                ContentMode.HTML);
        red.setSizeFull();

        ol.addComponent(red);
        mainWin.addComponent(ol);

    }
}
