/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.server.SystemError;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.TextField;

public class Ticket1663 extends com.vaadin.server.LegacyApplication {

    @Override
    public void init() {

        LegacyWindow main = new LegacyWindow("#1663");
        setMainWindow(main);

        TextField tf = new TextField("First name");
        tf.setDescription(
                "The first name is used for the administration user interfaces only.");
        tf.setComponentError(
                new SystemError("You must enter only one first name."));

        main.addComponent(tf);
    }
}
