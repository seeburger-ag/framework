/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.serialization;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class ChangeStateWhenReattaching extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Button button = new Button("Reattach and remove caption",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        Button button = event.getButton();
                        removeComponent(button);
                        addComponent(button);
                        button.setCaption(null);
                    }
                });
        addComponent(button);
    }

    @Override
    protected String getTestDescription() {
        return "Clicking the button should remove its caption, even though it is also reattached.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(10532);
    }

}
