/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tickets;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.LegacyApplication;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.LegacyWindow;

public class Ticket2095 extends LegacyApplication {

    @Override
    public void init() {
        LegacyWindow w = new LegacyWindow(getClass().getSimpleName());
        setMainWindow(w);

        // uncomment to workaround iorderedlayout bug in current trunk
        // w.setContent(new ExpandLayout());
        w.getContent().setSizeFull();

        Embedded em = new Embedded();
        em.setType(Embedded.TYPE_BROWSER);
        em.setSource(
                new ExternalResource("../statictestfiles/ticket2095.html"));
        em.setId("MYIFRAME");

        em.setSizeFull();

        w.addComponent(em);

    }
}
