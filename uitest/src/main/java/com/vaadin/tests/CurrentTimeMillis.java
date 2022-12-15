/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;

/**
 * Test UI (empty) to check high resolution time availability in browser.
 *
 * @author Vaadin Ltd
 */
public class CurrentTimeMillis extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        // no need to add anything
    }

    @Override
    protected Integer getTicketNumber() {
        return 14716;
    }

    @Override
    protected String getTestDescription() {
        return "Use high precision time is available instead of Date.getTime().";
    }
}
