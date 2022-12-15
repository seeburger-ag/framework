/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.CheckBox;

public class ComboBoxNoTextInput extends ComboBoxSelecting {

    @Override
    protected void setup(VaadinRequest request) {
        super.setup(request);
        comboBox.setTextInputAllowed(true);

        final CheckBox textInputCheckBox = new CheckBox("Text Input", true);
        textInputCheckBox.setId("textInput");
        textInputCheckBox.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                comboBox.setTextInputAllowed(textInputCheckBox.getValue());
            }
        });
        addComponent(textInputCheckBox);
    }

    @Override
    protected String getTestDescription() {
        return "ComboBox should open popup on click when text input is not allowed.";
    }

}
