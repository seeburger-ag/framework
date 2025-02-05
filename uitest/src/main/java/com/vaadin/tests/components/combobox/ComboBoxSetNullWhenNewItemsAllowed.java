/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;

public class ComboBoxSetNullWhenNewItemsAllowed extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final ComboBox comboBox = new ComboBox("My ComboBox");
        comboBox.setImmediate(true);
        comboBox.setNullSelectionAllowed(false);
        comboBox.setNewItemsAllowed(true);
        for (int i = 0; i < 10; i++) {
            comboBox.addItem("Item " + i);
        }

        final Label value = new Label("Selected: ");

        comboBox.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                if (comboBox.getValue() != null) {
                    comboBox.setValue(null);
                    value.setValue("Selected: " + (String) comboBox.getValue());
                }
            }
        });
        addComponent(comboBox);
        addComponent(value);
    }

    @Override
    protected String getTestDescription() {
        return "ComboBox should clear its value when setting to null with new items.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13413;
    }
}
