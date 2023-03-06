/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.Table;

public class Ticket1991 extends com.vaadin.server.LegacyApplication {

    @Override
    public void init() {
        final LegacyWindow main = new LegacyWindow(getClass().getName()
                .substring(getClass().getName().lastIndexOf(".") + 1));
        setMainWindow(main);

        Table t = new Table("Test table");

        t.addContainerProperty(" ", CheckBox.class, "");
        t.addContainerProperty("Col1", String.class, "");
        t.addContainerProperty("Col2", String.class, "");

        t.setPageLength(5);

        t.addItem(new Object[] { new CheckBox(), "Foo", "Bar" }, "1");
        t.addItem(new Object[] { new CheckBox(), "Foo", "Bar" }, "2");

        main.addComponent(t);
    }
}
