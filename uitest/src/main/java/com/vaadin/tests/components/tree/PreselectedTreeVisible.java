/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tree;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Tree;

@SuppressWarnings("serial")
public class PreselectedTreeVisible extends TestBase {

    @Override
    protected void setup() {

        String itemId1 = "Item 1";
        String itemId2 = "Item 2";

        Tree tree = new Tree();

        tree.addItem(itemId1);
        tree.addItem(itemId2);

        // Removing this line causes the tree to show normally in Firefox
        tree.select(itemId1);
        addComponent(tree);

    }

    @Override
    protected String getDescription() {
        return "Tree should be visible when a item has been selected.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 5396;
    }

}
