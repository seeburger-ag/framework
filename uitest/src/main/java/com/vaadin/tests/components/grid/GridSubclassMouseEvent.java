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
import com.vaadin.tests.util.PersonContainer;
import com.vaadin.tests.widgetset.TestingWidgetSet;

@Widgetset(TestingWidgetSet.NAME)
public class GridSubclassMouseEvent extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        PersonContainer container = PersonContainer.createWithTestData();
        GridSubclass grid = new GridSubclass(container);
        addComponent(grid);
    }
}
