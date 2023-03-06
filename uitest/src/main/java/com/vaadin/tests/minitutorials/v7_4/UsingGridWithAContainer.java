/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7_4;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

public class UsingGridWithAContainer extends UI {
    @Override
    protected void init(VaadinRequest request) {
        Grid grid = new Grid();
        grid.setContainerDataSource(GridExampleHelper.createContainer());

        grid.getColumn("name").setHeaderCaption("Bean name");
        grid.removeColumn("count");
        grid.setColumnOrder("name", "amount");

        setContent(grid);
    }
}
