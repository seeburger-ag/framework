/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.LegacyApplication;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.TextField;

public class Ticket2415 extends LegacyApplication {

    @Override
    public void init() {
        final LegacyWindow main = new LegacyWindow("");
        setMainWindow(main);

        final TextField tf = new TextField("Try to change me");
        main.addComponent(tf);

        tf.setImmediate(true);
        tf.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                main.showNotification("New value = " + tf);
            }
        });

        final TextField tf2 = new TextField("Try to change me");
        main.addComponent(tf2);

        tf2.setImmediate(true);
        tf2.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                main.showNotification("New value = " + tf2);
            }
        });

    }

}
