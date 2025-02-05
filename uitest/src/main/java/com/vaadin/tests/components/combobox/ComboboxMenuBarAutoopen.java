/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import java.util.ArrayList;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

/**
 * Test UI for combobox popup which should be closed on any click outside it.
 *
 * @author Vaadin Ltd
 */
public class ComboboxMenuBarAutoopen extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);
        ArrayList<String> options = new ArrayList<String>();
        options.add("1");
        options.add("2");
        options.add("3");
        ComboBox combo = new ComboBox(null, options);
        layout.addComponent(combo);

        MenuBar menubar = getMenubar();
        layout.addComponent(menubar);

        addComponent(layout);
    }

    @Override
    protected String getTestDescription() {
        return "Combobox popup should close on click to other popup or associated components.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14321;
    }

    private MenuBar getMenubar() {
        MenuBar menubar = new MenuBar();
        menubar.setAutoOpen(true);
        MenuItem item = menubar.addItem("auto-open", null);
        item.addItem("sub-item 1", new MenuBar.Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                Notification notification = new Notification("Test",
                        Type.HUMANIZED_MESSAGE);
                notification.show(Page.getCurrent());
            }
        });
        return menubar;
    }
}
