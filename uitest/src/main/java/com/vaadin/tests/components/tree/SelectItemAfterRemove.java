/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tree;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Tree;

public class SelectItemAfterRemove extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Tree tree = new Tree();

        tree.setImmediate(true);
        tree.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {

                tree.removeItem(tree.getValue());
                tree.select(event.getItemId());
            }
        });

        tree.addItem("first");
        tree.addItem("second");
        tree.addItem("third");

        tree.select("first");

        addComponent(tree);
    }

    @Override
    protected String getTestDescription() {
        return "Clicking on an item should select the clicked item and remove "
                + "the previously selected item.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 15181;
    }
}
