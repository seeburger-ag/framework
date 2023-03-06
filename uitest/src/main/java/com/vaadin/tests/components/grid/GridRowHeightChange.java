/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import java.util.Arrays;
import java.util.List;

public class GridRowHeightChange extends AbstractTestUI {

    private final List<String> themes = Arrays.asList("valo", "reindeer",
            "runo", "chameleon", "base");

    @Override
    protected void setup(VaadinRequest request) {
        Grid grid = new Grid();

        // create column and fill rows
        grid.addColumn("Header");
        for (int i = 1; i <= 10; i++) {
            grid.addRow("row_" + i);
        }

        // set height mode and height
        grid.setHeightMode(HeightMode.ROW);
        grid.setHeightByRows(10);

        // create a tabsheet with one tab and place grid inside
        VerticalLayout tab = new VerticalLayout();
        TabSheet tabSheet = new TabSheet();
        tabSheet.setWidthUndefined();
        tabSheet.addTab(tab, "Tab");
        tab.addComponent(grid);

        // Theme selector
        NativeSelect themeSelector = new NativeSelect("Theme selector", themes);
        themeSelector.select("reindeer");
        themeSelector.setNullSelectionAllowed(false);
        themeSelector
                .addValueChangeListener(new Property.ValueChangeListener() {
                    @Override
                    public void valueChange(Property.ValueChangeEvent event) {
                        setTheme((String) event.getProperty().getValue());
                    }
                });

        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setSizeUndefined();

        layout.addComponent(themeSelector);
        layout.addComponent(tabSheet);

        addComponent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "Test if Grid's height is adjusted when HeightMode.ROW and row height is recalculated.<br>"
                + "When loading is complete, all 10 rows should be visible with all themes.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 20104;
    }
}
