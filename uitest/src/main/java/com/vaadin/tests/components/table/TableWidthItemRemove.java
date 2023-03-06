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
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;

/**
 * Test whether adding the first item to a table calculates the table width
 * correctly
 *
 * @author Vaadin Ltd
 */
public class TableWidthItemRemove extends AbstractTestUI {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        final Table table = new Table("My table");
        table.addContainerProperty("firstName", String.class, null);
        table.addContainerProperty("lastName", String.class, null);
        table.addContainerProperty("year", Integer.class, null);
        table.setColumnWidth("firstName", 200);
        table.setColumnWidth("lastName", 100);
        table.setColumnWidth("year", 50);

        addButton("Clean", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                table.removeAllItems();
            }
        });

        addButton("Populate", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                table.addItem(new Object[] { "John", "Doe", new Integer(1980) },
                        Math.random() * 1000);
            }
        });

        addComponent(table);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "The table should retain the correct width on item remove and add.";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 13592;
    }

}
