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
import com.vaadin.tests.fieldgroup.ComplexPerson;
import com.vaadin.ui.Grid;

public class GridInitiallyHiddenColumns extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        Grid grid = new Grid();
        grid.setContainerDataSource(ComplexPerson.createContainer(100));
        grid.setColumns("firstName", "lastName", "age");
        grid.getColumn("firstName").setHidden(true).setHidable(true);
        grid.getColumn("lastName").setHidable(true);
        grid.getColumn("age").setHidden(true).setHidable(true);

        addComponent(grid);
    }
}
