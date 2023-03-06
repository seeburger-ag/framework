/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class GridInGridLayout extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        final CssLayout cssLayout = new CssLayout();
        cssLayout.setWidth("100%");
        layout.setHeight("320px");
        layout.setMargin(true);
        addComponent(cssLayout);
        cssLayout.addComponent(layout);

        final Grid grid = new Grid();
        grid.setSizeFull();
        for (int i = 0; i < 20; i++) {
            Grid.Column column = grid.addColumn("" + i);
            column.setHidable(true);
            column.setEditable(true);
        }
        grid.setEditorEnabled(true);
        grid.setColumnReorderingAllowed(true);
        for (int i = 0; i < 300; i++) {
            grid.addRow("Foo", "Bar", "far", "bar", "bar", "Foo", "Bar", "Bar",
                    "bar", "bar", "Foo", "Bar", "Bar", "bar", "bar", "Foo",
                    "Bar", "Bar", "bar", "bar");

        }
        layout.addComponent(grid);
        grid.setHeight("300px");
        grid.setWidth("400px");
    }

    @Override
    protected Integer getTicketNumber() {
        return 18698;
    }
}
