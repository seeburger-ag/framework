/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.customlayout;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.ui.AbstractComponent;

@Widgetset(TestingWidgetSet.NAME)
public class OverflowAutoFix extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new RunOverflowFix());
    }

    public class RunOverflowFix extends AbstractComponent {
    }

    @Override
    public String getTestDescription() {
        return "Overflow-x and overflow-y should be restored when using runWebkitOverflowAutoFix.<br>"
                + "Outer size: 300x200px, inner size: 350x250px";
    }

    @Override
    protected Integer getTicketNumber() {
        return 16650;
    }
}
