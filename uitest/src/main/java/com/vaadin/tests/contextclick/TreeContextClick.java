/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.contextclick;

import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.TreeContextClickEvent;

public class TreeContextClick
        extends AbstractContextClickUI<Tree, TreeContextClickEvent> {

    @Override
    protected Tree createTestComponent() {
        Tree tree = new Tree();
        tree.addItem("Foo");
        tree.addItem("Bar");
        tree.addItem("Baz");
        tree.setParent("Baz", "Bar");
        tree.setHeight("200px");
        return tree;
    }

    @Override
    protected void handleContextClickEvent(TreeContextClickEvent event) {
        log("ContextClickEvent: " + event.getItemId());
    }
}
