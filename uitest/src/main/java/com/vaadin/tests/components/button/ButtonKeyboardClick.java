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
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;

/**
 * Test UI for availability (x,y) coordinates for button activated via keyboard.
 *
 * @author Vaadin Ltd
 */
public class ButtonKeyboardClick extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Label[] labels = new Label[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new Label();
        }

        Button button = new Button("button", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Label label = new Label(String.valueOf(event.getClientX()));
                label.addStyleName("x");
                getLayout().replaceComponent(labels[0], label);
                labels[0] = label;

                label = new Label(String.valueOf(event.getClientY()));
                label.addStyleName("y");
                getLayout().replaceComponent(labels[1], label);
                labels[1] = label;

                label = new Label(String.valueOf(event.getRelativeX()));
                label.addStyleName("xRelative");
                getLayout().replaceComponent(labels[2], label);
                labels[2] = label;

                label = new Label(String.valueOf(event.getRelativeY()));
                label.addStyleName("yRelative");
                getLayout().replaceComponent(labels[3], label);
                labels[3] = label;
            }
        });
        addComponent(button);
    }

    @Override
    protected String getTestDescription() {
        return "Set client coordinates to the middle of the button when click is triggered from keyboard";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12650;
    }

}
