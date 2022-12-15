/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.formlayout;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;

/**
 * Test UI for Form layout click listener.
 *
 * @author Vaadin Ltd
 */
public class FormLayoutClickListener extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        FormLayout layout = new FormLayout();
        layout.setMargin(true);
        layout.setSpacing(true);

        layout.setId("form");

        Label label = new Label("target");
        label.setId("label");
        layout.addComponent(label);

        layout.addLayoutClickListener(new LayoutClickListener() {

            @Override
            public void layoutClick(LayoutClickEvent event) {
                log("Child component: " + (event.getChildComponent() == null
                        ? null : event.getChildComponent().getId()));
                log("Clicked component: " + (event.getClickedComponent() == null
                        ? null : event.getClickedComponent().getId()));
                log("Source component: " + event.getComponent().getId());
            }
        });

        addComponent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "LayoutClickListener should work in FormLayout";
    }

    @Override
    protected Integer getTicketNumber() {
        return 6346;
    }

}
