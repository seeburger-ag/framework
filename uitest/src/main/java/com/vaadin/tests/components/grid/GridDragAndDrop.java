/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import java.util.Arrays;
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;

@SuppressWarnings("serial")
public class GridDragAndDrop extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        List<String> columnIds = Arrays.asList("Hello", "this", "are",
                "multiple", "columns", "plus", "these", "resemble", "a",
                "group", "here", "no", "more");

        Grid grid = new Grid();

        for (String columnId : columnIds) {
            grid.addColumn(columnId);
        }

        for (int i = 0; i < 100; i++) {
            grid.addRow(columnIds.toArray());
        }

        grid.setColumnReorderingAllowed(true);

        grid.setFrozenColumnCount(1);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        addComponent(grid);
    }

    @Override
    protected String getTestDescription() {
        return "Start dragging a column header and move left and right.<br> The drop indicator should appear exactly on the lines between column headers.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 18925;
    }
}
