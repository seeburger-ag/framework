/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.debug;

import com.vaadin.tests.components.TestBase;

public class DebugWindowPresent extends TestBase {

    @Override
    protected void setup() {
        // Nothing to set up
    }

    @Override
    protected String getDescription() {
        return "The debug window should be present with &debug present in the url, but not othervise";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(7555);
    }

}
