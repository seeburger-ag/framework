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
import com.vaadin.tests.components.table.DndTableTargetDetails;
import com.vaadin.ui.Tree;

/**
 * Test UI for tree as a drop target: AbstractSelectTargetDetails should provide
 * getMouseEvent() method.
 *
 * @author Vaadin Ltd
 */
public class DndTreeTargetDetails extends DndTableTargetDetails {

    @Override
    protected void setup(VaadinRequest request) {
        createSourceTable();

        Tree target = new Tree();
        target.addStyleName("target");
        target.setWidth(100, Unit.PERCENTAGE);
        target.addItem("treeItem");
        target.setDropHandler(new TestDropHandler());
        addComponent(target);
    }

    @Override
    protected String getTestDescription() {
        return "Mouse details should be available for AbstractSelectTargetDetails DnD when tree is a target";
    }

}
