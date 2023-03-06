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
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.VerticalLayout;

public class GridColumnAutoExpand extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        addComponent(layout);

        Grid grid = new Grid("Broken Grid with Caption");
        grid.setWidth("100%");
        grid.setHeight("100px");

        Column col1 = grid.addColumn("Col1");
        col1.setWidth(100);

        Column col2 = grid.addColumn("Col2");
        col2.setMinimumWidth(100);
        col2.setExpandRatio(1);

        layout.addComponent(grid);
    }
}
