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
import com.vaadin.ui.Grid.MultiSelectionModel;
import com.vaadin.ui.Grid.SelectionMode;

public class GridMultiSelectionOnInit extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();
        grid.addColumn("foo", String.class);
        grid.addRow("Foo 1");
        grid.addRow("Foo 2");
        grid.setSelectionMode(SelectionMode.MULTI);
        addComponent(grid);

        addComponent(new Button("Select rows", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                ((MultiSelectionModel) grid.getSelectionModel()).setSelected(
                        grid.getContainerDataSource().getItemIds());
            }
        }));
    }
}
