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
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

public class InitialFrozenColumns extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Grid grid = new Grid();
        grid.setSelectionMode(SelectionMode.NONE);

        grid.addColumn("foo").setWidth(200);
        grid.addColumn("bar").setWidth(200);
        grid.addColumn("baz").setWidth(200);

        grid.addRow("a", "b", "c");

        grid.setFrozenColumnCount(2);

        addComponent(grid);
    }

}
