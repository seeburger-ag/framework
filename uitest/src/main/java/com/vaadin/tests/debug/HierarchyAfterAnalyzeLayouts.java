/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.debug;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

public class HierarchyAfterAnalyzeLayouts extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new Label("This is a label"));
    }

    @Override
    protected String getTestDescription() {
        return "The connector hierarchy should be in order after clicking AL in the debug console";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(11067);
    }

}
