/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.table;

import static org.junit.Assert.assertTrue;

import com.vaadin.tests.design.DeclarativeTestBase;
import com.vaadin.ui.Table;

public abstract class TableDeclarativeTestBase
        extends DeclarativeTestBase<Table> {

    @Override
    public Table testRead(String design, Table expected) {
        Table read = super.testRead(design, expected);
        compareColumns(read, expected);
        compareBody(read, expected);
        return read;
    }

    protected Table getTable() {
        return new Table();
    }

    protected String getTag() {
        return "vaadin-table";
    }

    protected void compareBody(Table read, Table expected) {
        assertEquals("number of items", expected.getItemIds().size(),
                read.getItemIds().size());
        for (Object rowId : expected.getItemIds()) {
            assertTrue(read.containsId(rowId));
            for (Object propertyId : read.getVisibleColumns()) {
                Object expectedItem = expected.getContainerProperty(rowId,
                        propertyId);
                Object readItem = read.getContainerProperty(rowId, propertyId);
                assertEquals("property '" + propertyId + "'", expectedItem,
                        readItem);
            }
        }
    }

    protected void compareColumns(Table read, Table expected) {
        for (Object pid : expected.getVisibleColumns()) {
            String col = "column '" + pid + "'";
            assertEquals(col + " width", expected.getColumnWidth(pid),
                    read.getColumnWidth(pid));
            assertEquals(col + " expand ratio",
                    expected.getColumnExpandRatio(pid),
                    read.getColumnExpandRatio(pid));
            assertEquals(col + " collapsible",
                    expected.isColumnCollapsible(pid),
                    read.isColumnCollapsible(pid));
            assertEquals(col + " collapsed", expected.isColumnCollapsed(pid),
                    read.isColumnCollapsed(pid));
            assertEquals(col + " footer", expected.getColumnFooter(pid),
                    read.getColumnFooter(pid));
        }
    }
}
