/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;

public class TabSheetErrorTooltip extends AbstractTestUI {

    private TabSheet tabSheet = new TabSheet();
    private int tabCount = 0;

    @Override
    protected void setup(VaadinRequest request) {

        addTab();
        addTab().setComponentError(new UserError("Error!"));
        addTab().setDescription("This is a tab");

        Tab t = addTab();
        t.setComponentError(new UserError("Error!"));
        t.setDescription("This tab has both an error and a description");

        setContent(tabSheet);
        getTooltipConfiguration().setOpenDelay(0);
        getTooltipConfiguration().setQuickOpenDelay(0);
        getTooltipConfiguration().setCloseTimeout(1000);
    }

    private Tab addTab() {
        tabCount++;
        Label contents = new Label("Contents for tab " + tabCount);
        return tabSheet.addTab(contents, "Tab " + tabCount);
    }

    @Override
    protected String getTestDescription() {
        return "TabSheet Tabs should display component error tooltips when expected";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12802;
    }

}
