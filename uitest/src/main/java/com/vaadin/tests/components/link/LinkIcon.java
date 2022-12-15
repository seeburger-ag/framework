/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.link;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Link;

public class LinkIcon extends TestBase {

    @Override
    protected String getDescription() {
        return "The icon of a Link component should have the same cursor as the text and should be clickable";
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void setup() {
        Link l = new Link("www.google.com",
                new ExternalResource("http://www.vaadin.com/"));
        l.setIcon(new ThemeResource("../runo/icons/32/calendar.png"));

        addComponent(l);
    }

}
