/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;

@Widgetset(TestingWidgetSet.NAME)
public class ClientRpcClass extends AbstractTestUI {

    public static String TEST_COMPONENT_ID = "testComponent";

    @Override
    protected void setup(VaadinRequest request) {
        ClientRpcClassComponent component = new ClientRpcClassComponent();
        component.setId(TEST_COMPONENT_ID);
        addComponent(component);

        component.pause();
    }

    @Override
    protected String getTestDescription() {
        return "UI showing dummy component where the wiget type is implementing the RPC interface.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(13056);
    }

}
