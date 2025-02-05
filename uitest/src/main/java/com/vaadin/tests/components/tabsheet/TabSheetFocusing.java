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
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;

public class TabSheetFocusing extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final TabSheet ts = new TabSheet();
        ts.setWidth("400px");
        ts.setHeight("200px");
        addComponent(ts);
        addComponent(new Button("Add tab", new ClickListener() {
            int i = 0;

            @Override
            public void buttonClick(ClickEvent event) {
                Tab t = ts.addTab(new Button("Tab " + ++i));
                ts.setSelectedTab(t);
                ts.focus();
            }
        }));
    }

    @Override
    protected String getTestDescription() {
        return "The tab scroller should stay in place when tabs are focused using server-side calls.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12343;
    }

}
