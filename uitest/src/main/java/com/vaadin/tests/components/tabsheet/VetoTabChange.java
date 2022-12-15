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
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;

@Theme("valo")
public class VetoTabChange extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final TabSheet ts = new TabSheet();
        ts.addSelectedTabChangeListener(new SelectedTabChangeListener() {
            @Override
            public void selectedTabChange(SelectedTabChangeEvent event) {
                ts.setSelectedTab(0);
            }
        });

        ts.addTab(new Label("Tab 1"), "Tab 1");
        ts.addTab(new Label("Tab 2"), "Tab 2");

        addComponent(ts);
    }

    @Override
    public String getDescription() {
        return "Tests the behavior when there's a listener that always changes back to the first tab.";
    }

}
