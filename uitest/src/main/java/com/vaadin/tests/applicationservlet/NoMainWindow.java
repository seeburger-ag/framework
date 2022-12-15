/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.applicationservlet;

import com.vaadin.tests.components.AbstractTestCase;

public class NoMainWindow extends AbstractTestCase {

    @Override
    protected String getDescription() {
        return "This should produce an stack trace with \"No window found. Did you remember to setMainWindow()?\"";
    }

    @Override
    protected Integer getTicketNumber() {
        return 3349;
    }

    @Override
    public void init() {

    }

}
