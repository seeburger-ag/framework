/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.tests;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

public class VerifyJreVersion extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        String jreVersion = "Using Java " + System.getProperty("java.version")
                + " by " + System.getProperty("java.vendor");
        Label jreVersionLabel = new Label(jreVersion);
        jreVersionLabel.setId("jreVersionLabel");

        addComponent(jreVersionLabel);
    }

    @Override
    protected String getTestDescription() {
        return "Test used to detect when the JRE used to run these tests have changed.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(11835);
    }

}
