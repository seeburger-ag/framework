/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;

/**
 * Test UI to verify that focus event actually update the ComboBox suggestion
 * popup
 *
 * @author Vaadin Ltd
 */
public class ComboBoxItemAddingWithFocusListener extends AbstractTestUI {

    private ComboBox cBox;

    @Override
    protected void setup(VaadinRequest request) {
        cBox = new ComboBox();
        addComponent(cBox);
        cBox.setImmediate(true);
        cBox.addItem("Foo");
        cBox.addItem("Bar");
        cBox.addFocusListener(new FocusListener() {

            int x = 0;

            @Override
            public void focus(FocusEvent event) {
                cBox.addItem("Focus" + (x++));
            }

        });
        addComponent(new Button("Focus Target"));
    }

    @Override
    protected String getTestDescription() {
        return "Item adding in focus listener causes popup to clear";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13635;
    }

}
