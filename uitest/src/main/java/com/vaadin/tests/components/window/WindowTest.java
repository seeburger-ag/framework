/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import com.vaadin.tests.components.panel.PanelTest;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WindowTest extends PanelTest<Window> {

    @Override
    protected Class<Window> getTestClass() {
        return Window.class;
    }

    @Override
    protected void addTestComponent(Window c) {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        c.setContent(layout);
        getMainWindow().addWindow(c);
        getTestComponents().add(c);
    }

}
