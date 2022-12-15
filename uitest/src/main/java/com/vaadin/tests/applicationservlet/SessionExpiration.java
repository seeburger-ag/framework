/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.applicationservlet;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class SessionExpiration extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        getSession().getSession().setMaxInactiveInterval(2);
        addButton("Click to avoid expiration", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                log("Clicked");
            }
        });
    }

    @Override
    protected String getTestDescription() {
        return "Test for what happens when the session expires (2 second expiration time).";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12139;
    }
}
