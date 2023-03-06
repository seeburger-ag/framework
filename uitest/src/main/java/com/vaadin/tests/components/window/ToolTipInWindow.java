/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * Test to demonstrate that tooltips are shown for both Window header and
 * content
 *
 * @author Vaadin Ltd
 */
public class ToolTipInWindow extends AbstractTestUI {

    Window window;

    @Override
    protected void setup(VaadinRequest request) {

        window = new Window("Caption", new Label("A label content"));
        window.setPositionX(300);
        window.setPositionY(200);
        window.setWidth("200px");
        window.setHeight("200px");
        window.setDescription("Tooltip");
        addWindow(window);

    }

}
