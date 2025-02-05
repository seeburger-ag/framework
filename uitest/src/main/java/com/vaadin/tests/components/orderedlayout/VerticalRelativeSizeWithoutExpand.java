/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.orderedlayout;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class VerticalRelativeSizeWithoutExpand extends UI {

    @Override
    protected void init(VaadinRequest request) {

        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);

        Panel panel1 = new Panel("This should not be seen");
        panel1.setSizeFull();
        VerticalLayout verticalLayout1 = new VerticalLayout();
        verticalLayout1.setSizeFull();
        Tree tree = new Tree();
        tree.setSizeFull();
        tree.setContainerDataSource(
                new BeanItemContainer<String>(String.class));
        String a = "aaaaaaaaaaaaaaaaaaaaaaaa";
        String b = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        String c = "ccccccccccccccccccccccccccccccccccccccccccccccccc";
        tree.addItem(a);
        tree.addItem(b);
        tree.addItem(c);
        tree.setChildrenAllowed(a, true);
        tree.setChildrenAllowed(b, true);
        tree.setParent(b, a);
        tree.setParent(c, b);
        verticalLayout1.addComponent(tree);
        panel1.setContent(verticalLayout1);
        layout.addComponent(panel1);

        final Panel panel2 = new Panel("This should use all space");
        panel2.setSizeFull();

        layout.addComponent(panel2);
        layout.setExpandRatio(panel2, 1);

    }

}
