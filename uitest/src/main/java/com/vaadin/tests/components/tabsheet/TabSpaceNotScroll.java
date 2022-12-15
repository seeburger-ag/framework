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
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

/**
 * If the space is pressed on the tabs of a tabsheet the browser default scroll
 * behavior must be prevented.
 *
 * @since
 * @author Vaadin Ltd
 */
public class TabSpaceNotScroll extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        TabSheet tabSheet = new TabSheet();

        for (int i = 0; i < 5; i++) {
            String caption = "Tab " + i;
            Component c = new Label(caption);
            tabSheet.addTab(c, caption);
        }

        addComponent(tabSheet);

        Label dontShowThis = new Label("Page scroll. This is bad.");

        VerticalLayout panel = new VerticalLayout();
        panel.setHeight("2000px");
        panel.addComponent(dontShowThis);
        panel.setComponentAlignment(dontShowThis, Alignment.MIDDLE_CENTER);

        addComponent(panel);
    }

    @Override
    protected String getTestDescription() {
        return "Pressing space on the tab should not scroll.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14320;
    }

}
