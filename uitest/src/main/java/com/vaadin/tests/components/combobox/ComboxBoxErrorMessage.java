/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.ComboBox;

public class ComboxBoxErrorMessage extends TestBase {

    @Override
    protected void setup() {
        ComboBox cb = new ComboBox("");
        cb.setRequired(true);
        cb.setRequiredError("You must select something");
        addComponent(cb);
    }

    @Override
    protected String getDescription() {
        return "The ComboBox should show an \"You must select something\" tooltip when the cursor is hovering it. Both when hovering the textfield and the dropdown button.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 3345;
    }

}
