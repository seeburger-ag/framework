/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.select;

import com.vaadin.event.FieldEvents;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.ComboBox;

public class FocusListenerBreaksDropdownMenu extends TestBase {

    @Override
    protected void setup() {
        final ComboBox comboBox = new ComboBox();
        for (int i = 0; i < 5; ++i) {
            comboBox.addItem("Item " + i);
        }

        comboBox.addListener(new FieldEvents.FocusListener() {
            @Override
            public void focus(FieldEvents.FocusEvent event) {
                comboBox.addItem();
            }
        });

        comboBox.setImmediate(true);
        addComponent(comboBox);
    }

    @Override
    protected String getDescription() {
        return "Clicking the dropdown arrow on a not-already-focused ComboBox "
                + "breaks the dropdown list if a FocusListener adds or removes items";
    }

    @Override
    protected Integer getTicketNumber() {
        return 8321;
    }

}
