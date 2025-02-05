/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.data.Item;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

public class SortLabelsInTable extends AbstractTestUI {

    @SuppressWarnings("unchecked")
    @Override
    protected void setup(VaadinRequest request) {
        Table t = new Table("A table with a text column and a Label column");
        t.addContainerProperty("text", String.class, null);
        t.addContainerProperty("label", Label.class, null);

        for (int i = 0; i < 20; i++) {
            Item item = t.addItem("" + i);
            item.getItemProperty("text").setValue("Text " + i);
            item.getItemProperty("label").setValue(new Label("Label " + i));
        }
        addComponent(t);
    }

    @Override
    protected String getTestDescription() {
        return "Tests that Labels are sorted in the same way than Strings are.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 8845;
    }

}
