/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tree;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Tree;

public class TreeHtmlContentAllowed extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        String textParent = "Just text";
        String htmlParent = "Some <b>html</b>";
        String textChild = "Child text";
        String htmlChild = "Child <i>html</i>";
        String htmlElementChild = "Child <span id='my-html-element'>element html</span>";

        final Tree tree = new Tree("A tree");
        tree.addItem(textParent);
        tree.addItem(htmlParent);
        tree.addItem(textChild);
        tree.addItem(htmlChild);
        tree.addItem(htmlElementChild);
        tree.setParent(textChild, textParent);
        tree.setParent(htmlChild, htmlParent);

        tree.setChildrenAllowed(textChild, false);
        tree.setChildrenAllowed(htmlChild, false);
        tree.setChildrenAllowed(htmlElementChild, false);

        final CheckBox toggle = new CheckBox("HTML content allowed",
                tree.isHtmlContentAllowed());
        toggle.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                tree.setHtmlContentAllowed(toggle.getValue().booleanValue());
            }
        });

        addComponents(tree, toggle);
    }

}
