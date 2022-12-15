/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Table;

public class RemoveItemOnClick extends AbstractTestUI {

    private Table table;

    @Override
    protected void setup(VaadinRequest request) {
        table = new Table();
        IndexedContainer ic = new IndexedContainer();
        populate(ic);
        table.setContainerDataSource(ic);
        table.setPageLength(20);
        table.setSelectable(true);
        table.setImmediate(true);
        table.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                table.removeItem(table.getValue());
            }
        });
        addComponent(table);
    }

    private void populate(Container container) {
        container.addContainerProperty("property1", String.class, "foo");
        container.addContainerProperty("property2", Integer.class, 1210);
        container.addContainerProperty("property3", String.class, "bar");

        for (int i = 0; i < 100; i++) {
            Item item = container.addItem("Item " + i);
            item.getItemProperty("property1").setValue("This is item " + i);
        }
    }

    @Override
    protected String getTestDescription() {
        return "Selecting a row should remove that row from the table";
    }

    @Override
    protected Integer getTicketNumber() {
        return 10071;
    }

}
