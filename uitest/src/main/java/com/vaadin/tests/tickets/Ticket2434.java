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
import com.vaadin.tests.TestForTablesInitialColumnWidthLogicRendering;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Table;

public class Ticket2434 extends LegacyApplication {

    @Override
    public void init() {

        LegacyWindow w = new LegacyWindow();

        setMainWindow(w);

        Table t = TestForTablesInitialColumnWidthLogicRendering.getTestTable(3,
                50);

        t.setPageLength(0);

        t.addStyleName("bordered");

        w.addComponent(t);

        setTheme("tests-tickets");

    }

}
