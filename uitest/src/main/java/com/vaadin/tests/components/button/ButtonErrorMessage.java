/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.button;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class ButtonErrorMessage extends TestBase {

    @Override
    protected void setup() {
        Button b = new Button("Click for error");
        b.addListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                throw new NullPointerException();
            }
        });
        addComponent(b);
    }

    @Override
    protected String getDescription() {
        return "Click the button for an exception. The exception should not contain any extra ',' characters";
    }

    @Override
    protected Integer getTicketNumber() {
        return 3303;
    }

}
