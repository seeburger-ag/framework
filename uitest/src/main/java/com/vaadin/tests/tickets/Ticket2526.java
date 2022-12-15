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
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Window;

public class Ticket2526 extends LegacyApplication {

    @Override
    public void init() {
        final LegacyWindow main = new LegacyWindow();
        setMainWindow(main);
        Button b = new Button("Add windows");
        b.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                main.addWindow(new Window());
            }
        });
        main.addComponent(b);
    }
}
