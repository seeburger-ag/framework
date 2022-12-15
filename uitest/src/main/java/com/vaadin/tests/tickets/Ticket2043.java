/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.LegacyApplication;
import com.vaadin.shared.ui.BorderStyle;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Link;

public class Ticket2043 extends LegacyApplication {

    @Override
    public void init() {
        LegacyWindow w = new LegacyWindow(getClass().getSimpleName());
        setMainWindow(w);
        // setTheme("tests-tickets");
        GridLayout layout = new GridLayout(10, 10);
        w.setContent(layout);
        createUI(layout);
    }

    private void createUI(GridLayout layout) {
        Link l = new Link("Vaadin home (new 200x200 window, no decor, icon)",
                new ExternalResource("http://www.vaadin.com"), "_blank", 200,
                200, BorderStyle.NONE);

        layout.addComponent(l);
    }
}
