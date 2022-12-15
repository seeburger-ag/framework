/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;

/**
 * Test to see if tabsheet navigation buttons render correctly in Chameleon
 *
 * @author Vaadin Ltd
 */
@Theme("chameleon")
public class TabsheetNotEnoughHorizontalSpace extends AbstractTestUI {

    private TabSheet tabsheet = new TabSheet();

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        generateTabs();
        tabsheet.setSizeFull();
        addComponent(tabsheet);

    }

    private void generateTabs() {
        tabsheet.removeAllComponents();
        for (int i = 0; i < 100; ++i) {
            tabsheet.addTab(new Panel(), "Tab" + i);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Scroll-buttons should render correctly on all browsers";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 12154;
    }

}
