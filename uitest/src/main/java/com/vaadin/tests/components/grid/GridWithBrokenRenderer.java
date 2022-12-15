/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.tests.integration.FlagSeResource;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.ImageRenderer;

public class GridWithBrokenRenderer extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();
        grid.addColumn("short", String.class);
        grid.addColumn("icon", Resource.class);
        grid.addColumn("country", String.class);

        grid.getColumn("icon").setRenderer(new ImageRenderer());
        addComponent(grid);

        grid.addRow("FI", new ClassResource("fi.gif"), "Finland");
        grid.addRow("SE", new FlagSeResource(), "Sweden");

    }

}
