/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.InlineDateField;

public class DateFieldFastForward extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new InlineDateField());
    }

    @Override
    protected String getTestDescription() {
        return "Tests that right-click doesn't interfere with fast-forwarding (holding down left mouse button).";
    }

    @Override
    protected Integer getTicketNumber() {
        return 8012;
    }

}
