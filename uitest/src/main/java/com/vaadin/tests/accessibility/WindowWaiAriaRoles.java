/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.accessibility;

import java.util.Stack;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.window.WindowRole;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window;

/**
 * UI to test if subwindows get the correct assistive roles.
 *
 * @author Vaadin Ltd
 */
public class WindowWaiAriaRoles extends AbstractTestUI {
    Stack<Window> windows = new Stack<Window>();

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        Button closeButton = new Button("Close windows");
        closeButton.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                while (!windows.isEmpty()) {
                    Window window = windows.pop();
                    removeWindow(window);
                }
            }

        });

        Button regularButton = new Button("Regular");
        regularButton.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Window regularWindow = new Window("Regular window");
                openWindow(regularWindow);
            }
        });

        Button alertButton = new Button("Alert");
        alertButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                Window alertWindow = new Window("Alert window");
                alertWindow.setAssistiveRole(WindowRole.ALERTDIALOG);
                openWindow(alertWindow);
            }
        });
        addComponent(closeButton);
        addComponent(regularButton);
        addComponent(alertButton);
    }

    void openWindow(Window window) {
        windows.push(window);
        window.center();
        addWindow(window);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "The alert window should have the role 'alertdialog' and the regular window should have the role 'dialog'";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 14289;
    }

}
