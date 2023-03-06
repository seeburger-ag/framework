/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TextField;

/**
 * Test for required text field.
 *
 * @author Vaadin Ltd
 */
public class RequiredTextField extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final TextField field = new TextField();

        addComponent(field);

        Button button = new Button("Set/unset required", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                field.setRequired(!field.isRequired());
            }
        });
        addComponent(button);
    }

    @Override
    protected String getTestDescription() {
        return "Add .v-required style when setRequired() is used";
    }

    @Override
    protected Integer getTicketNumber() {
        return 10201;
    }
}
