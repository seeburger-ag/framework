/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.notification;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

/**
 * Test UI class for Notification with middle left and middle right positions.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class MiddleNotificationPosition extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Button left = new Button("Show Notification in middle left");
        left.addStyleName("show-middle-left");
        left.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Notification notification = new Notification("Notification");
                notification.setDelayMsec(10000);
                notification.setPosition(Position.MIDDLE_LEFT);
                notification.show(getUI().getPage());
            }
        });
        addComponent(left);

        Button right = new Button("Show Notification in middle right");
        right.addStyleName("show-middle-right");
        right.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Notification notification = new Notification("Notification");
                notification.setDelayMsec(10000);
                notification.setPosition(Position.MIDDLE_RIGHT);
                notification.show(getUI().getPage());
            }
        });
        addComponent(right);

    }

    @Override
    protected String getTestDescription() {
        return "Position.MIDDLE_LEFT and Position.MIDDLE_RIGHT should work for Notification";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12931;
    }

}
