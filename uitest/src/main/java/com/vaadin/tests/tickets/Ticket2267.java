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
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.LegacyWindow;

public class Ticket2267 extends LegacyApplication {

    Label l = new Label("0");

    @Override
    public void init() {
        LegacyWindow w = new LegacyWindow(getClass().getSimpleName());
        setMainWindow(w);
        // setTheme("tests-tickets");
        GridLayout gl = new GridLayout(4, 2);

        Button button = new Button("1", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Button b = event.getButton();
                l.setValue(l.getValue() + b.getCaption());

            }

        });

        gl.addComponent(l, 0, 0, 3, 0);
        gl.addComponent(button);
        gl.addComponent(new Label("2"));
        gl.addComponent(new Label("3"));
        gl.addComponent(new Label("4"));

        w.setContent(gl);

    }
}
