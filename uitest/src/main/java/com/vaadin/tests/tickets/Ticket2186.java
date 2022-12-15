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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class Ticket2186 extends LegacyApplication {

    @Override
    public void init() {
        LegacyWindow main = new LegacyWindow("Quick test");
        setMainWindow(main);

        HorizontalLayout base = new HorizontalLayout();
        main.setContent(base);

        VerticalLayout content = new VerticalLayout();

        content.addComponent(new Label("Content."));
        content.setWidth("500px");

        Table table = new Table();

        table.setPageLength(10);

        table.setWidth("100%");

        table.addContainerProperty("Lähettäjä", String.class, "");
        table.addContainerProperty("Viestin tyyppi", String.class, "");

        for (int i = 0; i < 15; i++) {

            table.addItem(new Object[] { i + " Joku Ihminen", "Testiviesti" },

                    new Object());

        }

        content.addComponent(table);

        Panel right = new Panel("Panel");

        right.setContent(new Label("Some basic text might show up here."));

        base.addComponent(content);

        base.addComponent(right);

    }
}
