/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;

/**
 * This test UI is used for checking that when a tab is closed, another one is
 * scrolled into view.
 *
 * @since
 * @author Vaadin Ltd
 */
public class TabSheetClose extends AbstractTestUI {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        TabSheet tabsheet = new TabSheet();
        for (int loop = 0; loop < 3; loop++) {
            Tab tab = tabsheet.addTab(new CssLayout(), "tab " + loop);
            tab.setClosable(true);
            tab.setId("tab" + loop);
        }
        CssLayout layout = new CssLayout();
        layout.addComponent(tabsheet);
        layout.setWidth("150px");
        addComponent(layout);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "When all tabs have not been closed, at least one tab should be visible. ";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 14348;
    }
}
