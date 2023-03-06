/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import java.util.Arrays;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;

/**
 * @author Vaadin Ltd
 *
 */
public class HorizontalScrollAfterResize extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();
        grid.setWidth("100%");
        grid.setHeight("350px");
        grid.setCaption("My Grid");

        for (int i = 0; i < 10; i++) {
            char ch = (char) ('a' + i);
            grid.addColumn(ch, String.class);
        }
        for (int i = 0; i < 100; i++) {
            String[] row = new String[10];
            Arrays.fill(row, "test");
            grid.addRow(row);
        }

        addComponents(grid);
    }

    @Override
    protected String getTestDescription() {
        return "Don't add more than one scroll handler";
    }

    @Override
    protected Integer getTicketNumber() {
        return 19189; // also 20254, 19622
    }

}
