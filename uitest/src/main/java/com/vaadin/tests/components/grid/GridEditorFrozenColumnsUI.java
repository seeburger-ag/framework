/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.tests.util.PersonContainer;
import com.vaadin.ui.Grid;

public class GridEditorFrozenColumnsUI extends GridEditorUI {

    @Override
    protected Grid createGrid(PersonContainer container) {
        Grid grid = super.createGrid(container);

        grid.setFrozenColumnCount(2);

        grid.setWidth("600px");

        return grid;
    }

    @Override
    protected Integer getTicketNumber() {
        return 16727;
    }

    @Override
    protected String getTestDescription() {
        return "Frozen columns should also freeze cells in editor.";
    }
}
