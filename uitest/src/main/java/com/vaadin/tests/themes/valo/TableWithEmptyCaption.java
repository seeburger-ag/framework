/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

@Theme("valo")
public class TableWithEmptyCaption extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Table table = new Table();
        table.addContainerProperty("first", String.class, "");
        table.addContainerProperty("last", String.class, "");
        table.addContainerProperty("actions", Component.class, null);

        table.addItem(new Object[] { "Teemu", "Test", new Button("Edit") }, 1);
        table.addItem(new Object[] { "Dummy", "Test", new Button("Edit") }, 2);

        table.setPageLength(0);
        table.setColumnHeaders("First Name", "Last Name", "");

        table.setFooterVisible(true);
        table.setColumnFooter("first", "Footer");
        table.setColumnFooter("last", "");
        table.setColumnFooter("actions", "");
        addComponent(table);
    }

    @Override
    protected String getTestDescription() {
        return "Test that column headers (and footers) work properly with empty captions.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14812;
    }
}
