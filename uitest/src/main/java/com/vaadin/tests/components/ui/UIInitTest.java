/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

public class UIInitTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new Label("Hello UI"));
    }

    @Override
    public String getTestDescription() {
        return "Testing basic UI creation";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(3067);
    }
}
