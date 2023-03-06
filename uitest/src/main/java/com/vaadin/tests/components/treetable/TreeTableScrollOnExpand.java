/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.treetable;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.TreeTable;

public class TreeTableScrollOnExpand extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        TreeTable t = new TreeTable();
        t.setSelectable(true);
        t.setImmediate(true);
        t.setSizeFull();
        t.addContainerProperty("Name", String.class, "null");
        for (int i = 1; i <= 100; i++) {
            String parentID = "Item " + i;
            Object parent = t.addItem(new Object[] { parentID }, parentID);
            String childID = "Item " + (100 + i);
            Object child = t.addItem(new Object[] { childID }, childID);
            t.getContainerDataSource().setParent(childID, parentID);
        }
        addComponent(t);
    }

    @Override
    public Integer getTicketNumber() {
        return 18247;
    }

    @Override
    public String getTestDescription() {
        return "After selecting an item and scrolling it out of view, TreeTable should not scroll to the "
                + "selected item when expanding an item.";
    }
}