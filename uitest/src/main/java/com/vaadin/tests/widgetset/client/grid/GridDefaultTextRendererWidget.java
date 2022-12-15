/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.grid;

import com.vaadin.client.widget.grid.datasources.ListDataSource;
import com.vaadin.client.widgets.Grid;
import com.vaadin.client.widgets.Grid.Column;
import com.vaadin.client.widgets.Grid.SelectionMode;
import com.vaadin.shared.ui.grid.HeightMode;

public class GridDefaultTextRendererWidget
        extends PureGWTTestApplication<Grid<String>> {
    /*
     * This can't be null, because grid thinks that a row object of null means
     * "data is still being fetched".
     */
    private static final String NULL_STRING = "";

    private Grid<String> grid;

    public GridDefaultTextRendererWidget() {
        super(new Grid<String>());
        grid = getTestedWidget();

        grid.setDataSource(new ListDataSource<String>(NULL_STRING, "string"));
        grid.addColumn(new Column<String, String>() {
            @Override
            public String getValue(String row) {
                if (!NULL_STRING.equals(row)) {
                    return row;
                } else {
                    return null;
                }
            }
        });

        grid.addColumn(new Column<String, String>() {

            @Override
            public String getValue(String row) {
                return "foo";
            }

        });

        grid.setHeightByRows(2);
        grid.setHeightMode(HeightMode.ROW);
        grid.setSelectionMode(SelectionMode.NONE);
        addNorth(grid, 500);
    }
}
