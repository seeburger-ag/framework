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
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * Test that column width is restored after restoring column visibility
 */
@SuppressWarnings("serial")
public class TableToggleColumnVisibilityWidth extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();

        final Table table = new Table();

        table.addContainerProperty("Name", String.class, "");
        table.addContainerProperty("Last Name", String.class, "");

        table.setColumnWidth("Name", 100);
        table.setColumnWidth("Last Name", 200);
        table.setHeight("200px");

        table.addItem(new Object[] { "Adam", "Morrison" }, new Integer(1));
        table.addItem(new Object[] { "Eva", "Roberts" }, new Integer(2));
        table.addItem(new Object[] { "Rob", "Spears" }, new Integer(3));
        table.addItem(new Object[] { "Bob", "Michigan" }, new Integer(4));
        table.setVisibleColumns(new Object[] { "Name", "Last Name" });

        final Button infoToggler = new Button("visibility");
        infoToggler.setId("toggler");
        infoToggler.addClickListener(new ClickListener() {
            private boolean detailed = true;

            @Override
            public void buttonClick(ClickEvent event) {
                if (detailed) {
                    table.setVisibleColumns(new Object[] { "Name" });
                } else {
                    table.setVisibleColumns(
                            new Object[] { "Name", "Last Name" });
                }
                detailed = !detailed;
            }
        });

        layout.addComponent(table);
        layout.addComponent(infoToggler);

        addComponent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "Toggling visibility of table columns should not change the width of fixed sized columns";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12303;
    }

}
