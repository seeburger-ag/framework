/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class ResynchronizeUI extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        Button b = new Button("Resynchronize", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                // Theme change is currently the only operation which always
                // does resynchronize
                setTheme("runo");
                log("Set theme to runo");
            }
        });
        addComponent(b);
    }
}
