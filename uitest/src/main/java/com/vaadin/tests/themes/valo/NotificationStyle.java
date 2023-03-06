/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

/**
 * Test UI for H1 and P elements styles.
 *
 * @author Vaadin Ltd
 */
@Theme("valo")
public class NotificationStyle extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Button button = new Button("Show notification with h1",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        Notification notification = new Notification(
                                "<p>Caption</p>",
                                "<div style='display:inline-block;'><h1>Description</h1>"
                                        + "<p class='tested-p'>tested p</p></div>");
                        notification.setHtmlContentAllowed(true);
                        notification.setDelayMsec(50000);
                        notification.show(getPage());
                    }
                });
        addComponent(button);
        button = new Button("Show notification with p",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        Notification notification = new Notification(
                                "<p>Caption</p>",
                                "Description text<p class='tested-p'>tested p text</p>");
                        notification.setHtmlContentAllowed(true);
                        notification.setDelayMsec(50000);
                        notification.show(getPage());
                    }
                });
        addComponent(button);
    }

    @Override
    protected Integer getTicketNumber() {
        return 14872;
    }

    @Override
    protected String getTestDescription() {
        return "Notification styles should be scoped more eagerly.";
    }

}
