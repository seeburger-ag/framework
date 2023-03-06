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
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;

public class ComboBoxSelectingWithNewItemsAllowed extends ComboBoxSelecting {

    @Override
    protected void setup(VaadinRequest request) {
        super.setup(request);
        comboBox.setNewItemsAllowed(true);

        final Label label = new Label(
                String.valueOf(comboBox.getItemIds().size()));
        label.setCaption("Item count:");
        label.setId("count");
        comboBox.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                label.setValue(String.valueOf(comboBox.getItemIds().size()));
            }
        });
        addComponent(label);
    }

    @Override
    protected String getTestDescription() {
        return "ComboBox should select value on TAB also when new items are allowed.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 9369;
    }
}
