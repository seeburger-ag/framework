/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Window;

public class WindowWithIcon extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Window window = new Window("Window Caption");
        window.setIcon(FontAwesome.ROCKET);
        addWindow(window);
    }

    @Override
    protected String getTestDescription() {
        return "Window should work properly with font icons.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14481;
    }

}
