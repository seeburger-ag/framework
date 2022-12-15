/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.extensions;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

@Widgetset("com.vaadin.tests.widgetset.TestingWidgetSet")
public class HelloWorldExtensionTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final HelloWorldExtension extension = new HelloWorldExtension();
        extension.setGreeting("Kind words");
        addExtension(extension);

        addComponent(new Button("Greet again", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                extension.greetAgain();
            }
        }));
    }

    @Override
    protected String getTestDescription() {
        return "Testing basic Extension";
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}
