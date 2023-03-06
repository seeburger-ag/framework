/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.tests.components.window;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

public class WindowThemes extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Window def = new Window("default", new Label("Some content"));
        def.setWidth("300px");
        def.setHeight("100%");
        addWindow(def);

        Window light = new Window("WINDOW_LIGHT", new Label("Some content"));
        light.setStyleName(Reindeer.WINDOW_LIGHT);
        light.setPositionX(300);
        light.setWidth("300px");
        light.setHeight("100%");
        addWindow(light);

        Window black = new Window("WINDOW_BLACK", new Label("Some content"));
        black.setStyleName(Reindeer.WINDOW_BLACK);
        black.setPositionX(600);
        black.setWidth("300px");
        black.setHeight("100%");
        addWindow(black);
    }

    @Override
    protected String getTestDescription() {
        return "Shows the different css themes of Window";
    }

    @Override
    protected Integer getTicketNumber() {
        // Not tied to any specific ticket
        return null;
    }
}
