/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.treetable;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.vaadin.ui.TreeTable;

public class EmptyTreeTableTest {

    @Test
    public void testLastId() {
        TreeTable treeTable = new TreeTable();

        assertFalse(treeTable.isLastId(treeTable.getValue()));
    }
}
