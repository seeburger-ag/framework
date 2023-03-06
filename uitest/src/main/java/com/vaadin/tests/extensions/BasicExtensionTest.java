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
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;

@Widgetset("com.vaadin.tests.widgetset.TestingWidgetSet")
public class BasicExtensionTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Label label = new Label();
        addComponent(label);

        final BasicExtension rootExtension = new BasicExtension();
        rootExtension.extend(this);
        new BasicExtension().extend(label);
        addComponent(new Button("Remove root extension", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                rootExtension.remove();
            }
        }));
    }

    @Override
    protected String getTestDescription() {
        return "Simple test for extending components";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(6690);
    }

}
