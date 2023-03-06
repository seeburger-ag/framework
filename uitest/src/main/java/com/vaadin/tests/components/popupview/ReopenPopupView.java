/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.util.Log;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.PopupView;

public class ReopenPopupView extends AbstractTestUI {
    private final Log log = new Log(5);

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(log);
        addComponent(new PopupView("PopupView",
                new Button("Button", new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        log.log("Button clicked");
                    }
                })));
    }

    @Override
    protected String getTestDescription() {
        return "Clicking a button in a PopupView should work every time";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(8804);
    }

}
