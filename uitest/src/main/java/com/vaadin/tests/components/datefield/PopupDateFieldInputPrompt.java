/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;

/**
 * Tests that state change doesn't set input prompt back to PopupDateField if
 * focus is still in the input field.
 *
 * @author Vaadin Ltd
 */
public class PopupDateFieldInputPrompt extends AbstractTestUI {

    private TextField text = new TextField("TextField");
    private PopupDateField dateField = new PopupDateField();

    @Override
    protected void setup(VaadinRequest request) {

        text.addValueChangeListener(new ValueChangeListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void valueChange(ValueChangeEvent event) {
                // update PopupDateField's state
                dateField.setRequired(!dateField.isRequired());
            }
        });

        dateField.setInputPrompt("prompt");
        dateField.setCaption("PopupDateField");

        addComponent(text);
        addComponent(dateField);
    }

    @Override
    protected String getTestDescription() {
        return "Write something to the TextField and use tabulator to move to PopupDateField."
                + "<br>PopupDateField shouldn't get input prompt back before focus leaves the input field,"
                + "<br>even if TextField's value change updates PopupDateField's state.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 18027;
    }

}
