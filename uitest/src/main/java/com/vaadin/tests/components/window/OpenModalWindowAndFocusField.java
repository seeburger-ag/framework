/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.Window;

public class OpenModalWindowAndFocusField extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        Button button = new Button("Open modal and focus textarea");
        button.setId("openFocus");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                open(true);
            }
        });
        addComponent(button);

        button = new Button("Only open modal");
        button.setId("open");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                open(false);
            }

        });
        addComponent(button);

    }

    private void open(boolean focus) {
        Window wind = new Window();
        wind.setModal(true);
        TextArea ta = new TextArea();
        wind.setContent(ta);
        addWindow(wind);
        if (focus) {
            ta.focus();
        }
    }
}
