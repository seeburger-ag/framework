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
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.CellReference;
import com.vaadin.ui.Grid.CellStyleGenerator;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;

public class GridInTabSheet extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        TabSheet sheet = new TabSheet();
        final Grid grid = new Grid();
        grid.setSelectionMode(SelectionMode.MULTI);
        grid.addColumn("count", Integer.class);
        for (Integer i = 0; i < 3; ++i) {
            grid.addRow(i);
        }

        sheet.addTab(grid, "Grid");
        sheet.addTab(new Label("Hidden"), "Label");

        addComponent(sheet);
        addComponent(new Button("Add row to Grid", new Button.ClickListener() {

            private Integer k = 0;

            @Override
            public void buttonClick(ClickEvent event) {
                grid.addRow(100 + (k++));
            }
        }));
        addComponent(
                new Button("Remove row from Grid", new Button.ClickListener() {

                    private Integer k = 0;

                    @Override
                    public void buttonClick(ClickEvent event) {
                        Object firstItemId = grid.getContainerDataSource()
                                .firstItemId();
                        if (firstItemId != null) {
                            grid.getContainerDataSource()
                                    .removeItem(firstItemId);
                        }
                    }
                }));
        addComponent(new Button("Add CellStyleGenerator",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        grid.setCellStyleGenerator(new CellStyleGenerator() {
                            @Override
                            public String getStyle(
                                    CellReference cellReference) {
                                int rowIndex = ((Integer) cellReference
                                        .getItemId()).intValue();
                                Object propertyId = cellReference
                                        .getPropertyId();
                                if (rowIndex % 4 == 1) {
                                    return null;
                                } else if (rowIndex % 4 == 3
                                        && "Column 1".equals(propertyId)) {
                                    return null;
                                }
                                return propertyId.toString().replace(' ', '_');
                            }
                        });
                    }
                }));
    }
}
