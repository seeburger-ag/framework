/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textarea;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.TextArea;

public class TextDisappearsOnBlur extends TestBase {

    @Override
    protected void setup() {
        TextArea ta = new TextArea();
        addComponent(ta);

        // All three are required for the bug to manifest
        ta.setMaxLength(50);
        ta.setImmediate(true);
        ta.setRequired(true);
    }

    @Override
    protected String getDescription() {
        return "Text disappears from TextArea in IE 6-8 when focus changes";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11396;
    }

}
