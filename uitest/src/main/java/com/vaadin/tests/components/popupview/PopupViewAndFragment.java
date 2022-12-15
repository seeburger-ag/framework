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
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;

public class PopupViewAndFragment extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final PopupView pw = new PopupView("Open", new Label("Oh, hi"));
        addComponent(pw);

        final Button button = new Button("Open and change fragment",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(final ClickEvent event) {
                        pw.setPopupVisible(true);
                        getPage().setUriFragment(
                                String.valueOf(System.currentTimeMillis()));
                    }
                });
        addComponent(button);
    }

    @Override
    protected String getTestDescription() {
        return "Changing frament should not automatically close PopupView";
    }

    @Override
    protected Integer getTicketNumber() {
        return 10530;
    }

}
