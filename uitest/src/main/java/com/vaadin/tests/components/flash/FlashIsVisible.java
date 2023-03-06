/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.flash;

import com.vaadin.server.ClassResource;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Flash;

public class FlashIsVisible extends TestBase {

    @Override
    protected void setup() {
        Flash player = new Flash();
        player.setWidth("400px");
        player.setHeight("300px");
        player.setSource(new ClassResource("simple.swf"));
        addComponent(player);
    }

    @Override
    protected String getDescription() {
        return "Flash plugin should load and be visible on all browsers";
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}
