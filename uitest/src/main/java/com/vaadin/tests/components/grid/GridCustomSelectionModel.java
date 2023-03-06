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
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.ui.Grid.MultiSelectionModel;

@Widgetset(TestingWidgetSet.NAME)
public class GridCustomSelectionModel extends AbstractTestUI {

    public static class MySelectionModel extends MultiSelectionModel {
    }

    @Override
    protected void setup(VaadinRequest request) {
        PersonTestGrid grid = new PersonTestGrid(500);
        grid.setSelectionModel(new MySelectionModel());
        addComponent(grid);
    }

}
