/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.orderedlayout;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class VerticalLayoutFocusWithDOMChanges extends AbstractTestUI
        implements ValueChangeListener {

    Button dummyButton = new Button("Just a button");
    TextField listenedTextField = new TextField();
    TextField changingTextField = new TextField();

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        setSizeFull();
        listenedTextField.addValueChangeListener(this);
        listenedTextField.setImmediate(true);
        changingTextField.setImmediate(true);
        content.addComponent(dummyButton);
        content.addComponent(listenedTextField);
        content.addComponent(changingTextField);
        content.setMargin(true);
        content.setSpacing(true);
        setContent(content);
    }

    @Override
    protected String getTestDescription() {
        return "Check that creating or removing caption wrap doesn't lose focus";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12967;
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        changingTextField.setRequired(!changingTextField.isRequired());
    }

}
