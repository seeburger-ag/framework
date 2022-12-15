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
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

/**
 * UI for notification delay test.
 *
 * @author Vaadin Ltd
 */
public class NotificationDelay extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Notification notification = new Notification("Foo",
                Type.HUMANIZED_MESSAGE);
        notification.setDelayMsec(500);
        notification.show(getPage());
    }

    @Override
    protected String getTestDescription() {
        return "Notification should be closed after delay";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14689;
    }

}
