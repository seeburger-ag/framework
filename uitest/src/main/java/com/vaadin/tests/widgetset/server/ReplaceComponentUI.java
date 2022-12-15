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
public class ReplaceComponentUI extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new ReplaceComponent());
    }

    @Override
    protected String getTestDescription() {
        return "Tests that the right client-side connector is used when there are multiple connectors with @Connect mappings to the same server-side component.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(9826);
    }

}
