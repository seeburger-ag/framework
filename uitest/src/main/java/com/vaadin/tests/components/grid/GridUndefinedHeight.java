/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
public class GridUndefinedHeight extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();

        final Grid grid = new Grid();
        grid.addColumn("toString", String.class);
        grid.addRow("Foo");
        grid.addRow("Bar");
        grid.addRow("Baz");
        grid.setHeightMode(HeightMode.UNDEFINED);

        layout.addComponents(grid,
                new Button("Add header row", new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        grid.appendHeaderRow();
                    }
                }));
        layout.setHeight("600px");
        layout.setExpandRatio(grid, 1.0f);

        addComponent(layout);
    }

}