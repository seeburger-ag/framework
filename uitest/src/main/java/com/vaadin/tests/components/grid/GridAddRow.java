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
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

public class GridAddRow extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        final Grid grid = new Grid();
        grid.setSelectionMode(SelectionMode.MULTI);
        grid.addColumn("firstName");
        grid.addColumn("age", Integer.class);

        grid.addRow("Lorem", Integer.valueOf(1));
        grid.addRow("Ipsum", Integer.valueOf(2));

        addComponent(grid);

        addComponent(new Button("Add new row", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                grid.addRow("Dolor", Integer.valueOf(3));
            }
        }));

    }

}
