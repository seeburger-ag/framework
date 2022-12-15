/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;

public class GridSingleColumn extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        IndexedContainer indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("column1", String.class, "");

        for (int i = 0; i < 100; i++) {
            Item addItem = indexedContainer.addItem(i);
            addItem.getItemProperty("column1").setValue("cell");
        }

        Grid grid = new Grid(indexedContainer);
        grid.setSelectionMode(SelectionMode.NONE);

        Column column = grid.getColumn("column1");

        column.setHeaderCaption("Header");

        addComponent(grid);
        grid.scrollTo(grid.getContainerDataSource().getIdByIndex(50));
    }

    @Override
    protected String getTestDescription() {
        return "Tests a single column grid";
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }

}
