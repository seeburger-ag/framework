/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.debug;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.client.ProfilerCompilationCanary;
import com.vaadin.tests.widgetset.server.TestWidgetComponent;

@Widgetset(TestingWidgetSet.NAME)
public class ProfilerZeroOverhead extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new TestWidgetComponent(ProfilerCompilationCanary.class));
    }

    @Override
    protected String getTestDescription() {
        return "Test UI for verifying that Profiler.isEnabled() causes no side effects in generated javascript";
    }
}
