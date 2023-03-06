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
import com.vaadin.tests.widgetset.server.GenericWidgetComponent;

@Widgetset(TestingWidgetSet.NAME)
public class GenericWidgetHandling extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final GenericWidgetComponent component = new GenericWidgetComponent();
        component.setId("label");
        component.setGenericText("The generic text is strong in this one");
        addComponent(component);
    }

    @Override
    protected String getTestDescription() {
        return "Tests that a connector works even if its widget is of a generic type";
    }

    @Override
    protected Integer getTicketNumber() {
        // Also 12900 if someone happens to care
        return Integer.valueOf(12873);
    }

}
