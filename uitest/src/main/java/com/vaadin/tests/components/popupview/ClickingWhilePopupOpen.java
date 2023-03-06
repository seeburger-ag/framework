/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;

public class ClickingWhilePopupOpen extends TestBase {

    @Override
    protected void setup() {
        Label popup = new Label("Popup");
        popup.setSizeUndefined();
        addComponent(new PopupView("Click here to open the popup", popup));
    }

    @Override
    protected String getDescription() {
        return "Clicking the popup view when the popup is already open throws a client-side IllegalStateException";
    }

    @Override
    protected Integer getTicketNumber() {
        return 8786;
    }

}
