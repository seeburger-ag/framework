/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;

public class ComboBoxSuggestionPopupClose extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final ComboBox select = new ComboBox("ComboBox");
        select.addItem("one");
        select.addItem("two");
        select.addItem("three");
        addComponent(select);
    }

    @Override
    protected String getTestDescription() {
        return "Closing the suggestion popup using Enter key is "
                + "broken in combobox when opening popup using Enter "
                + "key and not changin the selection using arrows";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14379;
    }
}
