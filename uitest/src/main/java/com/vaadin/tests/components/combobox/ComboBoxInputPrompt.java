/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;

public class ComboBoxInputPrompt extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final ComboBox cb1 = new ComboBox("Normal");
        cb1.setInputPrompt("Normal input prompt");

        final ComboBox cb2 = new ComboBox("Disabled");
        cb2.setEnabled(false);
        cb2.setInputPrompt("Disabled input prompt");

        final ComboBox cb3 = new ComboBox("Read-only");
        cb3.setReadOnly(true);
        cb3.setInputPrompt("Read-only input prompt");

        Button enableButton = new Button("Toggle enabled",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        cb2.setEnabled(!cb2.isEnabled());
                        cb3.setReadOnly(!cb3.isReadOnly());
                    }
                });

        addComponents(cb1, cb2, cb3, enableButton);
    }

    @Override
    protected String getTestDescription() {
        return "ComboBox should not display the input prompt if disabled or read-only.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 10573;
    }

}
