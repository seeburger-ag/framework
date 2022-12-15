/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.serialization;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.server.DummyLabel;
import com.vaadin.ui.Label;

@Widgetset(TestingWidgetSet.NAME)
public class SerializerNamespaceTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new Label("The real label"));
        addComponent(new DummyLabel("The dummy label"));
    }

    @Override
    protected String getTestDescription() {
        return "Using connectors with different state classes having the same simple name should not cause any client-side exceptions";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(8683);
    }

}
