/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.util.ResizeTerrorizer;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

@Widgetset(TestingWidgetSet.NAME)
public class GridResizeTerror extends UI {
    @Override
    protected void init(VaadinRequest request) {
        Grid grid = new Grid();

        int cols = 10;
        Object[] data = new Object[cols];

        for (int i = 0; i < cols; i++) {
            grid.addColumn("Col " + i);
            data[i] = "Data " + i;
        }

        for (int i = 0; i < 500; i++) {
            grid.addRow(data);
        }

        ResizeTerrorizer terrorizer = new ResizeTerrorizer(grid);
        setContent(terrorizer);
    }
}
