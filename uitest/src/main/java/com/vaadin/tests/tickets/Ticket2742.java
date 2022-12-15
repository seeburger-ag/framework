/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.tests.tickets;

import com.vaadin.server.LegacyApplication;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.NativeSelect;

/**
 * @author Risto Yrjänä / Vaadin Ltd.
 *
 */
public class Ticket2742 extends LegacyApplication {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.Application#init()
     */
    @Override
    public void init() {
        LegacyWindow mainWindow = new LegacyWindow();
        setMainWindow(mainWindow);

        String shortString = "Short";
        String longString = "Very, very long";

        HorizontalLayout hl = new HorizontalLayout();

        for (int i = 0; i < 2; i++) {
            NativeSelect ns = new NativeSelect(shortString);
            ns.addItem(longString);
            ns.setNullSelectionAllowed(false);
            ns.select(longString);
            hl.addComponent(ns);
        }
        mainWindow.addComponent(hl);
    }

}
