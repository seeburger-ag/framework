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
import com.vaadin.tests.components.AbstractTestUIWithLog;

public class VerifyAssertionsEnabled extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        try {
            assert false;
            log("Assertions are not enabled");
        } catch (AssertionError e) {
            log("Assertions are enabled");
        }
    }

    @Override
    protected String getTestDescription() {
        return "Tests whether the testing server is run with assertions enabled.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(9450);
    }

}
