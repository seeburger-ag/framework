/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;

public class TableRequiredIndicator extends AbstractTestUI {

    static final String TABLE = "table";
    static final String COUNT_SELECTED_BUTTON = "button";
    static final int TOTAL_NUMBER_OF_ROWS = 300;
    static final String COUNT_OF_SELECTED_ROWS_LABEL = "label";

    @Override
    protected void setup(VaadinRequest request) {

        final Table table = new Table();
        table.setId(TABLE);
        table.setSelectable(true);
        table.addContainerProperty("row", String.class, null);
        for (int i = 0; i < TOTAL_NUMBER_OF_ROWS; i++) {
            Object itemId = table.addItem();
            table.getContainerProperty(itemId, "row").setValue("row " + i);
        }
        addComponent(table);

        // This should cause red asterisk to the vertical layout
        table.setRequired(true);

        table.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                Object value = table.getValue();
                if (value != null) {
                    Notification.show("Value is set.");
                } else {
                    Notification.show("Value is NOT set.");
                }

            }
        });
    }

    @Override
    protected String getTestDescription() {
        return "Table is required and should have red asterisk to indicate that.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13008;
    }

}
