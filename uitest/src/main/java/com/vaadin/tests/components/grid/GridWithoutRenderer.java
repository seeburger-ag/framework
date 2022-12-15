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
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.util.PersonContainer;
import com.vaadin.ui.Grid;

@Theme("valo")
public class GridWithoutRenderer extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Grid grid = new Grid();
        grid.setContainerDataSource(PersonContainer.createWithTestData());
        addComponent(grid);

    }
}
