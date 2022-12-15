/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tree;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Tree;

/**
 * Test UI for keyboard navigation for first and last tree item.
 *
 * @author Vaadin Ltd
 */
public class TreeKeyboardNavigationToNone extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Tree tree = new Tree();
        tree.addItem("a");
        tree.addItem("b");

        tree.select("a");
        addComponents(tree);
        tree.focus();

        Button button = new Button("Select last item",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        tree.select("b");
                        tree.focus();
                    }
                });
        addComponent(button);
    }

    @Override
    protected Integer getTicketNumber() {
        return 15343;
    }

    @Override
    protected String getTestDescription() {
        return "Keyboard navigation should not throw client side exception "
                + "when there are no items to navigate.";
    }

}
