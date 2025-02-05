/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import java.util.EnumSet;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.VerticalLayout;

public class GridColumnWidthsWithoutData extends AbstractTestUI {

    private SelectionMode selectionMode = SelectionMode.NONE;
    private Grid grid = createGrid(true);

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(grid);

        NativeSelect selectionModeSelector = new NativeSelect("Selection mode",
                EnumSet.allOf(SelectionMode.class));
        selectionModeSelector.setValue(selectionMode);
        selectionModeSelector.setNullSelectionAllowed(false);
        selectionModeSelector.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                selectionMode = (SelectionMode) event.getProperty().getValue();
                grid.setSelectionMode(selectionMode);
            }
        });
        addComponent(selectionModeSelector);

        addComponent(
                new Button("Recreate without data", new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        replaceGrid(createGrid(false));
                    }
                }));

        addComponent(
                new Button("Recreate with data", new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        replaceGrid(createGrid(true));
                    }
                }));

        addComponent(new Button("Add data", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                addDataToGrid(grid);
            }
        }));

        addComponent(new Button("Remove data", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                grid.getContainerDataSource().removeAllItems();
            }
        }));

    }

    private void replaceGrid(Grid newGrid) {
        ((VerticalLayout) grid.getParent()).replaceComponent(grid, newGrid);
        grid = newGrid;
    }

    private Grid createGrid(boolean withData) {
        Grid grid = new Grid();
        grid.addColumn("foo");
        grid.addColumn("bar");
        grid.setWidth("300px");
        grid.setSelectionMode(selectionMode);

        if (withData) {
            addDataToGrid(grid);
        }

        return grid;
    }

    private void addDataToGrid(Grid grid) {
        grid.addRow("Some", "Data with more data in one col");
    }

}
