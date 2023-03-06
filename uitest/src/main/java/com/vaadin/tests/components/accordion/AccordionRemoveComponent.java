/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.accordion;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

/**
 * Test for removing component from Accordion.
 *
 * @author Vaadin Ltd
 */
public class AccordionRemoveComponent extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Accordion accordion = new Accordion();
        Button button = new Button("remove");
        button.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                accordion.removeComponent(event.getButton());
            }
        });
        accordion.addComponent(button);
        addComponent(accordion);
    }

    @Override
    protected String getTestDescription() {
        return "Reset selected index when tab is removed";
    }

    @Override
    protected Integer getTicketNumber() {
        return 17248;
    }
}
