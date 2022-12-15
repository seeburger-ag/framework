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
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

public class WindowWithInvalidCloseListener extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Window w = new Window("Close me");
        w.addCloseListener(new CloseListener() {

            @Override
            public void windowClose(CloseEvent e) {
                throw new RuntimeException(
                        "Close listener intentionally failed");
            }
        });
        addWindow(w);
    }

    @Override
    protected String getTestDescription() {
        return "The window has a close listener which throws an exception. This should not prevent the window from being closed.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 10779;
    }

}
