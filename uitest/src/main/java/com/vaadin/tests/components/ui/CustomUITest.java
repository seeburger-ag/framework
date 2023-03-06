/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.ui;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.client.CustomUIConnectorRpc;

@Widgetset(TestingWidgetSet.NAME)
public class CustomUITest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        getRpcProxy(CustomUIConnectorRpc.class).test();
    }

    @Override
    protected String getTestDescription() {
        return "It should be possible to change the implementation of the UIConnector class";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(10867);
    }

}
