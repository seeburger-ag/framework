/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.TextField;

public class Ticket1772 extends com.vaadin.server.LegacyApplication {

    @Override
    public void init() {

        final LegacyWindow main = new LegacyWindow(getClass().getName()
                .substring(getClass().getName().lastIndexOf(".") + 1));
        setMainWindow(main);

        Button b = new Button("Add content");
        main.addComponent(b);

        final GridLayout gridLayout = new GridLayout(2, 2);
        main.addComponent(gridLayout);

        b.addListener(new Button.ClickListener() {
            int counter = 0;

            @Override
            public void buttonClick(ClickEvent event) {

                gridLayout
                        .addComponent(new TextField("Content " + (++counter)));

            }
        });

    }

}
