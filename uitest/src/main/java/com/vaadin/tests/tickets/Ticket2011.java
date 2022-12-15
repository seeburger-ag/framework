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
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Select;

public class Ticket2011 extends LegacyApplication {

    @Override
    public void init() {
        LegacyWindow w = new LegacyWindow(getClass().getName());
        setMainWindow(w);
        // setTheme("tests-ticket");
        GridLayout layout = new GridLayout(10, 10);
        w.setContent(layout);
        createUI(layout);
    }

    private void createUI(GridLayout layout) {
        Select s = new Select("Select");
        s.addItem("Item 1");
        s.addItem("Item 2");
        layout.addComponent(s);
    }
}
