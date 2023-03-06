/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.button;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class ButtonIOSDragTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();

        Button offset = new Button("Drag me");
        offset.addListener(new ClickListener() {
            @Override
            public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
                Notification.show("Button clicked!");
            }
        });
        DragAndDropWrapper dragMe = new DragAndDropWrapper(offset);
        dragMe.setDragStartMode(DragStartMode.WRAPPER);
        layout.addComponent(dragMe);
        addComponent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "Test dragging of Button in iOS - dragging from the inside of the button to the outside and releasing should not cause a ClickEvent to be fired.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 7690;
    }

}
