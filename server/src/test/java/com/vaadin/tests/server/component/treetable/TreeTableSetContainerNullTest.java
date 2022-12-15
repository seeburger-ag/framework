/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.treetable;

import org.junit.Test;

import com.vaadin.ui.TreeTable;

public class TreeTableSetContainerNullTest {

    @Test
    public void testNullContainer() {
        TreeTable treeTable = new TreeTable();

        // should not cause an exception
        treeTable.setContainerDataSource(null);
    }
}
