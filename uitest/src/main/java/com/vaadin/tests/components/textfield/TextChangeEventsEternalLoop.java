/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.TextField;

public class TextChangeEventsEternalLoop extends TestBase {
    @Override
    protected void setup() {

        final TextField tf = new TextField("Debug");
        getLayout().addComponent(tf);

        tf.addListener(new TextChangeListener() {
            @Override
            public void textChange(TextChangeEvent event) {
                tf.setValue(event.getText());
            }
        });
    }

    @Override
    protected String getDescription() {
        return "Moving current text to value in text change listener should not cause eternal loop.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 6376;
    }

}
