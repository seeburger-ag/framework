/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.checkbox;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;

public class CheckBoxImmediate extends AbstractTestUI {
    private int count = 0;

    @Override
    protected void setup(VaadinRequest request) {
        final Label status = new Label("Events received: " + count);
        status.setId("count");
        addComponent(status);

        CheckBox cb = new CheckBox("Non-immediate");
        ValueChangeListener listener = new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                count++;
                status.setValue("Events received: " + count);
            }
        };
        cb.addValueChangeListener(listener);
        cb.setImmediate(false);
        addComponent(cb);

        cb = new CheckBox("Immediate");
        cb.addValueChangeListener(listener);
        cb.setImmediate(true);
        addComponent(cb);
    }

    @Override
    protected String getTestDescription() {
        return "Test for verifying that a non-immediate CheckBox does not send value change to server immediately.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 18102;
    }

}
