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
import com.vaadin.ui.Label;

@Widgetset(TestingWidgetSet.NAME)
public class PreserveCustomDebugSectionOpen extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new Label(
                "UI for testing that a custom debug window section remains open after refreshging."));
    }

}
