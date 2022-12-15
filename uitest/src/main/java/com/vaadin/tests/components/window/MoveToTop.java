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
import com.vaadin.ui.Window;

/**
 *
 * @author Vaadin Ltd
 */
public class MoveToTop extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Window window = new Window("one");
        window.addStyleName("first-window");
        window.setWidth(200, Unit.PIXELS);
        window.setHeight(100, Unit.PIXELS);
        window.setPositionX(100);
        window.setPositionY(100);
        addWindow(window);

        window = new Window("two");
        window.setWidth(200, Unit.PIXELS);
        window.setHeight(100, Unit.PIXELS);
        window.setPositionX(150);
        window.setPositionY(150);
        window.addStyleName("second-window");
        addWindow(window);
    }

    @Override
    protected String getTestDescription() {
        return "Bring to front window on click it's header";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13445;
    }

}
