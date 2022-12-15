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
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.LegacyWindow;

/**
 * #5053: Last ComboBox item may not be shown if null selection enabled
 */
public class Ticket5053 extends LegacyApplication {

    @Override
    public void init() {
        LegacyWindow main = new LegacyWindow();
        setMainWindow(main);

        ComboBox combobox = new ComboBox("My ComboBox");

        // Enable null selection
        combobox.setNullSelectionAllowed(true);
        // Add the item that marks 'null' value
        String nullitem = "-- none --";
        combobox.addItem(nullitem);
        // Designate it was the 'null' value marker
        combobox.setNullSelectionItemId(nullitem);

        // Add some other items
        for (int i = 0; i < 10; i++) {
            combobox.addItem("Item " + i);
        }

        main.addComponent(combobox);
    }

}
