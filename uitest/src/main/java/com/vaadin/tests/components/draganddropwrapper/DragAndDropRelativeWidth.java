/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.draganddropwrapper;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Label;

/**
 * Test UI for DnD image element size
 *
 * @author Vaadin Ltd
 */
public class DragAndDropRelativeWidth extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        CssLayout layout = new CssLayout();
        layout.setWidth(300, Unit.PIXELS);

        Label label = new Label("drag source");
        label.addStyleName("drag-source");
        label.setWidth(100, Unit.PERCENTAGE);
        DragAndDropWrapper wrapper = new DragAndDropWrapper(label);
        wrapper.setWidth(100, Unit.PERCENTAGE);
        wrapper.setDragStartMode(DragStartMode.COMPONENT);

        layout.addComponent(wrapper);
        addComponent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "Set explicit size for drag image element using calclulated size from the source";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14617;
    }

}
