/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.table;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.vaadin.ui.Table;

public class TableVisibleColumnsTest {

    String[] defaultColumns3 = new String[] { "Property 0", "Property 1",
            "Property 2" };

    @Test
    public void defaultVisibleColumns() {
        for (int properties = 0; properties < 10; properties++) {
            Table t = TableGeneratorTest
                    .createTableWithDefaultContainer(properties, 10);
            Object[] expected = new Object[properties];
            for (int i = 0; i < properties; i++) {
                expected[i] = "Property " + i;
            }
            org.junit.Assert.assertArrayEquals("getVisibleColumns", expected,
                    t.getVisibleColumns());
        }
    }

    @Test
    public void explicitVisibleColumns() {
        Table t = TableGeneratorTest.createTableWithDefaultContainer(5, 10);
        Object[] newVisibleColumns = new Object[] { "Property 1",
                "Property 2" };
        t.setVisibleColumns(newVisibleColumns);
        assertArrayEquals("Explicit visible columns, 5 properties",
                newVisibleColumns, t.getVisibleColumns());

    }

    @Test
    public void invalidVisibleColumnIds() {
        Table t = TableGeneratorTest.createTableWithDefaultContainer(3, 10);

        try {
            t.setVisibleColumns(
                    new Object[] { "a", "Property 2", "Property 3" });
            junit.framework.Assert.fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK, expected
        }
        assertArrayEquals(defaultColumns3, t.getVisibleColumns());
    }

    @Test
    public void duplicateVisibleColumnIds() {
        Table t = TableGeneratorTest.createTableWithDefaultContainer(3, 10);
        try {
            t.setVisibleColumns(new Object[] { "Property 0", "Property 1",
                    "Property 2", "Property 1" });
        } catch (IllegalArgumentException e) {
            // OK, expected
        }
        assertArrayEquals(defaultColumns3, t.getVisibleColumns());
    }

    @Test
    public void noVisibleColumns() {
        Table t = TableGeneratorTest.createTableWithDefaultContainer(3, 10);
        t.setVisibleColumns(new Object[] {});
        assertArrayEquals(new Object[] {}, t.getVisibleColumns());

    }
}
