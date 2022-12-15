/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.splitpanel;

import com.vaadin.server.Sizeable;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class SplitPanelInModalWindow extends TestBase {

    @Override
    public void setup() {

        VerticalLayout vl = new VerticalLayout();
        final Window modalWindow = new Window("Modeless Window", vl);
        vl.setWidth(200, Sizeable.UNITS_PIXELS);
        vl.setHeight(200, Sizeable.UNITS_PIXELS);
        modalWindow.setModal(true); // This line causes the problem
        getMainWindow().addWindow(modalWindow);

        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
        splitPanel.setSplitPosition(20);
        vl.addComponent(splitPanel);
    }

    @Override
    protected String getDescription() {
        return "Moving the splitter in the modal window should work as expected and not cause the application to freeze.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 4067;
    }

}
