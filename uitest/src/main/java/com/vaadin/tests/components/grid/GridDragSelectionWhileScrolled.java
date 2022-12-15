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
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

public class GridDragSelectionWhileScrolled extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Layout layout = new VerticalLayout();

        HorizontalLayout spacer = new HorizontalLayout();
        spacer.setHeight("1000px");
        layout.addComponent(spacer);

        PersonTestGrid grid = new PersonTestGrid(100);
        grid.setSelectionMode(SelectionMode.MULTI);
        layout.addComponent(grid);

        addComponent(layout);
    }

    @Override
    protected Integer getTicketNumber() {
        return 17895;
    }

    @Override
    protected String getTestDescription() {
        return "Drag selecting rows in Grid malfunctions if page is scrolled";
    }
}
