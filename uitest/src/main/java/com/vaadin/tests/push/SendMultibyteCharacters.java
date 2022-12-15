/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.TextArea;

@Push
public class SendMultibyteCharacters extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        TextArea textArea = new TextArea();
        textArea.setImmediate(true);

        addComponent(textArea);
    }

    @Override
    protected Integer getTicketNumber() {
        return 14674;
    }
}
