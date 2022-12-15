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
import com.vaadin.tests.util.TestUtils;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class TextChangeListenerLosesFocus extends TestBase {

    private final TextChangeListener listener = new TextChangeListener() {
        public void textChange(TextChangeEvent event) {
            final String value = event.getText();
            if (value.length() > 2) {
                ((Field) event.getComponent())
                        .setValue("Updated by TextChangeListener");
            }
        }
    };

    @Override
    protected void setup() {
        TestUtils.injectCSS(getMainWindow(),
                ".v-textfield-focus, .v-textarea-focus { "
                        + " background: #E8F0FF !important }");

        AbstractTextField field = new TextField();
        field.setDebugId("test-textfield");
        field.setInputPrompt("Enter at least 3 characters");
        field.addListener(listener);
        addComponent(field);

        field = new TextArea();
        field.setDebugId("test-textarea");
        field.setInputPrompt("Enter at least 3 characters");
        field.addListener(listener);
        addComponent(field);

    }

    @Override
    protected String getDescription() {
        return "Updating a focused TextField overwrites the focus stylename";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11623;
    }
}
