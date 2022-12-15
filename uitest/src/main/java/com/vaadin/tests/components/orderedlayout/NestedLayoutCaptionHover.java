/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.orderedlayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.VerticalLayout;

/**
 * Test hovering over nested layout caption
 *
 * @author Vaadin Ltd
 */
public class NestedLayoutCaptionHover extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout test = new VerticalLayout();
        test.setCaption("inner layout");
        addComponent(new VerticalLayout(
                new VerticalLayout(new VerticalLayout(test))));
    }

    @Override
    protected String getTestDescription() {
        return "Hovering over nested layout caption should not freeze the browser";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12469;
    }
}
