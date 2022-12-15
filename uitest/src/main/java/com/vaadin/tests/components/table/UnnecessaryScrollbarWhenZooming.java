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

public class UnnecessaryScrollbarWhenZooming extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Table table = new Table("A Table");
        table.setId("test-table");
        table.addContainerProperty("Text property 1", String.class, null);
        table.addContainerProperty("Text property 2", String.class, null);
        table.addContainerProperty("Text property 3", String.class, null);
        table.addContainerProperty("Numeric property", Integer.class, null);
        table.addItem(new Object[] { "Value 1 ", "Value 2", "Value 3",
                new Integer(39) }, new Integer(1));
        table.addItem(new Object[] { "Value 1 ", "Value 2", "Value 3",
                new Integer(39) }, new Integer(2));
        table.setWidth("100%");
        table.setPageLength(0);
        addComponent(table);
    }

    @Override
    protected String getTestDescription() {
        return "Test case for extra scrollbar being displayed in Table when browser window is zoomed (or page length is 0)";
    }

    @Override
    protected Integer getTicketNumber() {
        return 15164;
    }

}
