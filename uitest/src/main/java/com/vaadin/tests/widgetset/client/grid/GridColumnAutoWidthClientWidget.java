/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.client.renderers.HtmlRenderer;
import com.vaadin.client.widget.grid.datasources.ListDataSource;
import com.vaadin.client.widgets.Grid;
import com.vaadin.client.widgets.Grid.SelectionMode;

public class GridColumnAutoWidthClientWidget
        extends PureGWTTestApplication<Grid<List<String>>> {

    private Grid<List<String>> grid;

    private class Col extends Grid.Column<String, List<String>> {
        public Col(String header) {
            super(header, new HtmlRenderer());
            setExpandRatio(0);
        }

        @Override
        public String getValue(List<String> row) {
            int index = grid.getColumns().indexOf(this);
            return "<span>" + String.valueOf(row.get(index)) + "</span>";
        }
    }

    public GridColumnAutoWidthClientWidget() {
        super(new Grid<List<String>>());
        grid = getTestedWidget();
        grid.setSelectionMode(SelectionMode.NONE);
        grid.setWidth("750px");

        List<List<String>> list = new ArrayList<List<String>>();
        list.add(Arrays.asList("equal length", "a very long cell content",
                "short", "fixed width narrow", "fixed width wide"));
        grid.setDataSource(new ListDataSource<List<String>>(list));

        addColumn("equal length");
        addColumn("short");
        addColumn("a very long header content");
        addColumn("fixed width narrow").setWidth(50);
        addColumn("fixed width wide").setWidth(200);

        addNorth(grid, 400);
    }

    private Col addColumn(String header) {
        Col column = grid.addColumn(new Col(header));
        grid.getHeaderRow(0).getCell(column)
                .setHtml("<span>" + header + "</span>");
        return column;
    }
}
