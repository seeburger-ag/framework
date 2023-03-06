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

public class Ticket1925 extends LegacyApplication {

    @Override
    public void init() {
        LegacyWindow mainWindow = new LegacyWindow("Test åäö");
        setMainWindow(mainWindow);

    }

}
