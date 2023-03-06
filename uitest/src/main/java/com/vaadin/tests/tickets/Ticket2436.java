/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.server.LegacyApplication;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.PopupView;

public class Ticket2436 extends LegacyApplication {

    @Override
    public void init() {
        final LegacyWindow main = new LegacyWindow();
        setMainWindow(main);

        final Button remover = new Button("Remove PopupView");
        final PopupView pv = new PopupView(new PopupView.Content() {
            @Override
            public String getMinimizedValueAsHTML() {
                return "PopupView";
            }

            @Override
            public Component getPopupComponent() {
                return remover;
            }
        });

        remover.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                main.removeComponent(pv);
            }
        });

        main.addComponent(pv);
    }

}
