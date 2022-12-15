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
import java.util.List;

import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

public class GridThemeChange extends AbstractTestUI {
    private final List<String> themes = Arrays.asList("valo", "reindeer",
            "runo", "chameleon", "base");

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();
        grid.setSelectionMode(SelectionMode.SINGLE);

        grid.addColumn("Theme");
        for (String theme : themes) {
            Object itemId = grid.addRow(theme);
            if (theme.equals(getTheme())) {
                grid.select(itemId);
            }
        }

        grid.addSelectionListener(new SelectionListener() {
            @Override
            public void select(SelectionEvent event) {
                Object selectedItemId = grid.getSelectedRow();
                Object theme = grid.getContainerDataSource()
                        .getItem(selectedItemId).getItemProperty("Theme")
                        .getValue();
                setTheme(String.valueOf(theme));
            }
        });

        addComponent(grid);

    }
}
