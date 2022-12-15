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
import com.vaadin.ui.Grid;

public class GridDisabledMultiselect extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();
        grid.addColumn("foo", String.class);
        grid.addRow("bar");
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        addComponent(grid);

        addButton("Multi", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                grid.setSelectionMode(Grid.SelectionMode.MULTI);
            }
        });

        addButton("Disable", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                grid.setEnabled(!grid.isEnabled());
            }
        });
    }
}