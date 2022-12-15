/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.TabSheet;

public class EmptyTabSheet extends TestBase {

    private TabSheet tabSheet;

    @Override
    protected String getDescription() {
        return "Test a TabSheet without any tabs.";
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }

    @Override
    protected void setup() {
        tabSheet = new TabSheet();
        tabSheet.setId("tabsheet");
        addComponent(tabSheet);
    }

}
