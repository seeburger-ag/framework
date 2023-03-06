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
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;

public class GridEditingWithNoScrollBars extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Grid grid = new Grid();
        grid.addColumn("foo", String.class);
        grid.addColumn("bar", String.class);
        for (int i = 0; i < 10; ++i) {
            grid.addRow("foo", "" + (i % 3 + 1));
        }

        ComboBox stCombo = new ComboBox();
        stCombo.addItem("" + 1);
        stCombo.addItem("" + 2);
        stCombo.addItem("" + 3);
        stCombo.setNullSelectionAllowed(false);
        stCombo.setSizeFull();

        Column stCol = grid.getColumn("bar");
        stCol.setEditorField(stCombo);

        grid.setSelectionMode(SelectionMode.SINGLE);
        grid.setEditorEnabled(true);
        grid.setSizeFull();

        addComponent(grid);
    }

}
