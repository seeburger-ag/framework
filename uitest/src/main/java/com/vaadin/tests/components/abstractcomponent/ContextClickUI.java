/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.abstractcomponent;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ContextClickEvent.ContextClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class ContextClickUI extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        final ContextClickListener listener = new ContextClickListener() {

            @Override
            public void contextClick(ContextClickEvent event) {
                log("Received context click at (" + event.getClientX() + ", "
                        + event.getClientY() + ")");
            }
        };
        getUI().addContextClickListener(listener);

        addComponent(new Button("Remove listener", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                getUI().removeContextClickListener(listener);
            }
        }));
    }
}
