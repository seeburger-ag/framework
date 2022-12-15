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
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.vaadin.client.data.DataChangeHandler;
import com.vaadin.client.data.DataSource;
import com.vaadin.client.renderers.HtmlRenderer;
import com.vaadin.client.widgets.Grid;
import com.vaadin.client.widgets.Grid.SelectionMode;

public class GridCellFocusOnResetSizeWidget
        extends PureGWTTestApplication<Grid<String[]>> {

    private Grid<String[]> grid;

    private final class MyDataSource implements DataSource<String[]> {
        List<String[]> rows = new ArrayList<String[]>();
        int ROWS_MAX = 10;
        int size = ROWS_MAX;
        DataChangeHandler handler = null;
        {
            for (int i = 0; i < ROWS_MAX; ++i) {
                rows.add(new String[] { "Foo " + i });
            }
        }

        @Override
        public void ensureAvailability(int firstRowIndex, int numberOfRows) {
            handler.dataAvailable(firstRowIndex, numberOfRows);
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public void setDataChangeHandler(DataChangeHandler dataChangeHandler) {
            handler = dataChangeHandler;
        }

        @Override
        public RowHandle<String[]> getHandle(final String[] rowData) {
            return null;
        }

        @Override
        public String[] getRow(int rowIndex) {
            if (rowIndex < size && rowIndex >= 0) {
                return rows.get(rowIndex);
            }
            return null;
        }

        public void changeSize() {
            size--;
            if (size < ROWS_MAX / 2) {
                size = ROWS_MAX;
            }
            handler.resetDataAndSize(size);
        }

        @Override
        public boolean isWaitingForData() {
            return false;
        }
    }

    private class Col extends Grid.Column<String, String[]> {
        public Col(String header) {
            super(header, new HtmlRenderer());
        }

        @Override
        public String getValue(String[] row) {
            int index = grid.getColumns().indexOf(this);
            return "<span>" + String.valueOf(row[index]) + "</span>";
        }
    }

    public GridCellFocusOnResetSizeWidget() {
        super(new Grid<String[]>());
        grid = getTestedWidget();
        grid.setSelectionMode(SelectionMode.NONE);
        grid.setWidth("300px");
        grid.addColumn(new Col("Foo"));
        final MyDataSource dataSource = new MyDataSource();
        grid.setDataSource(dataSource);
        Button widget = new Button("Change Container Size");
        widget.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                dataSource.changeSize();
            }
        });
        addNorth(grid, 400);
        addNorth(widget, 50);
    }
}
