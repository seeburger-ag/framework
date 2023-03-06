/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.menubar;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;

/**
 * Test to see if tooltips will render in the correct locations near the edges.
 *
 * @author Vaadin Ltd
 */
public class MenuBarTooltipsNearEdge extends AbstractTestUI {
    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout vlayout = new VerticalLayout();
        vlayout.setSizeFull();
        vlayout.addComponent(buildMenu("Menu"));
        vlayout.setComponentAlignment(vlayout.getComponent(0),
                Alignment.BOTTOM_RIGHT);
        setContent(vlayout);

        getTooltipConfiguration().setOpenDelay(0);
        getTooltipConfiguration().setQuickOpenDelay(0);
        getTooltipConfiguration().setCloseTimeout(1000);

    }

    private Component buildMenu(String label) {
        MenuBar menu = new MenuBar();
        MenuItem item = menu.addItem(label, null);

        item.addItem("Item 1", null).setDescription("TOOLTIP 1");
        item.addItem("Item 2", null).setDescription("TOOLTIP 2");
        item.addItem("Item 3", null).setDescription("TOOLTIP 3");
        item.addItem("Item 4", null).setDescription("TOOLTIP 4");

        return menu;
    }

    private Command buildCommand() {
        Command command = new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {

            }
        };
        return command;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Menu item tooltips should not abscure other menu items";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 12870;
    }
}
