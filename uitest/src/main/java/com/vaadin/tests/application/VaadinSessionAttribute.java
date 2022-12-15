/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.application;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

public class VaadinSessionAttribute extends AbstractTestUI {

    private static final String ATTR_NAME = "myAttribute";

    @Override
    protected void setup(VaadinRequest request) {
        getSession().setAttribute(ATTR_NAME, Integer.valueOf(42));
        getSession().setAttribute(Integer.class, Integer.valueOf(42 * 2));

        addComponent(
                new Button("Show attribute values", new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        Notification notification = new Notification(
                                getSession().getAttribute(ATTR_NAME) + " & "
                                        + getSession()
                                                .getAttribute(Integer.class));
                        notification.setDelayMsec(Notification.DELAY_FOREVER);
                        notification.show(getPage());
                    }
                }));
    }

    @Override
    protected String getTestDescription() {
        return "Test to verify that session attributes are saved between requests.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(9514);
    }

}
