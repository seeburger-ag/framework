/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.customlayout;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.TextField;

public class CustomLayoutWithMissingSlot extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        CustomLayout cl;
        try {
            cl = new CustomLayout(new ByteArrayInputStream(
                    "<div>First: <div location='first'></div><p>Second: <div location='second'></div><p>"
                            .getBytes("UTF-8")));
            cl.addComponent(new TextField("This should be visible"), "first");
            Button button = new Button(
                    "This button is visible, together with one label");
            button.addClickListener(new ClickListener() {

                @Override
                public void buttonClick(ClickEvent event) {
                    log("Button clicked");
                }
            });
            cl.addComponent(button, "second");
            cl.addComponent(
                    new TextField("This won't be as the slot is missing"),
                    "third");

            addComponent(cl);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
