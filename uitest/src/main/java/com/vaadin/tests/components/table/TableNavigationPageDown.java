/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Table;

public class TableNavigationPageDown extends AbstractTestUI {

    private final static int ROW_NUMBER = 50;

    @Override
    protected void setup(VaadinRequest req) {
        Table table = new Table();
        table.setSelectable(true);
        table.setImmediate(true);
        table.setHeight("150px");

        table.addContainerProperty("num", Integer.class, "num");
        table.addContainerProperty("Foo", String.class, "Foov");
        table.addContainerProperty("Bar", String.class, "Barv");

        for (int i = 0; i < ROW_NUMBER; i++) {
            Object key = table.addItem();
            table.getItem(key).getItemProperty("num").setValue(i);
        }

        addComponent(table);

    }

    @Override
    protected String getTestDescription() {
        return "Navigation in Table with PageDown/PageUp/Home/End keys should work";
    }

    @Override
    protected Integer getTicketNumber() {
        return 15332;
    }

}
