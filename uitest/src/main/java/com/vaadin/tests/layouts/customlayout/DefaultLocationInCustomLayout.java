/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.customlayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomLayout;

@SuppressWarnings("serial")
public class DefaultLocationInCustomLayout extends AbstractTestUI {

    protected static final String BUTTON_ID = "DefaultLocationInCustomLayoutTestButtonId";

    @Override
    protected Integer getTicketNumber() {
        return 14340;
    }

    @Override
    protected String getTestDescription() {
        return "A test for adding a component at the default location in a "
                + "CustomLayout: a button should be visible.";
    }

    @Override
    protected void setup(VaadinRequest request) {
        setTheme("tests-tickets");
        CustomLayout customLayout = new CustomLayout("Ticket14340");
        final Button button = new Button("Button");
        button.setId(BUTTON_ID);
        customLayout.addComponent(button);
        addComponent(customLayout);
    }

}
