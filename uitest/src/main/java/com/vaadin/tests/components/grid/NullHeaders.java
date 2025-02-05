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
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Grid;

public class NullHeaders extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();
        grid.addColumn("country", String.class);
        grid.addColumn("foo", String.class);
        grid.addColumn("bar", Integer.class);

        grid.getColumn("country").setHeaderCaption(null);
        grid.getColumn("foo").setHeaderCaption("");
        grid.getColumn("bar").setHeaderCaption(null);
        grid.addRow("Finland", "foo", 1);
        grid.addRow("Swaziland", "bar", 2);
        grid.addRow("Japan", "baz", 3);
        addComponent(grid);
    }

}
