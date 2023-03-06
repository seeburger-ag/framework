/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;

public class Ticket1506 extends CustomComponent {

    Panel p;

    public Ticket1506() {
        p = new Ticket1506_Panel();
        setCompositionRoot(p);
    }

}
