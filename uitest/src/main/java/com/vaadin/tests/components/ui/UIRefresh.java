/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

@PreserveOnRefresh
public class UIRefresh extends AbstractTestUI {

    public static final String REINIT_ID = "reinit";

    @Override
    protected void setup(VaadinRequest request) {
    }

    @Override
    protected void refresh(VaadinRequest request) {
        Label l = new Label("Reinit!");
        l.setId(REINIT_ID);
        addComponent(l);
    }

    @Override
    public String getTestDescription() {
        return "UI reinit after refresh";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(12191);
    }
}
