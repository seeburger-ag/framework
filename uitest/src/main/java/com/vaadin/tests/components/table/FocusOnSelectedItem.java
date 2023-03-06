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
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;

/**
 * Test to see if the correct row gets the focus when the row is selected from
 * the serverside and forces the table to scroll down
 *
 * @author Vaadin Ltd
 */
public class FocusOnSelectedItem extends AbstractTestUI {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {

        final Table table = new Table();
        table.setSelectable(true);
        table.setImmediate(true);

        table.addContainerProperty("Property", String.class, null);

        for (int i = 0; i < 200; i++) {
            table.addItem(new String[] { "Item " + i }, "Item " + i);
        }
        addComponent(table);

        addButton("Select", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                table.setValue("Item 198");
                table.setCurrentPageFirstItemId("Item 198");
                table.focus();
            }
        });
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Test whether the selected row retains focus.";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 10522;
    }

}
