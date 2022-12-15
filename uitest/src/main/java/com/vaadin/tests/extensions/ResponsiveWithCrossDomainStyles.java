/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.extensions;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

@StyleSheet("http://fonts.googleapis.com/css?family=Cabin+Sketch")
public class ResponsiveWithCrossDomainStyles extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new Button("Make responsive", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                event.getButton().setResponsive(true);
            }
        }));
    }

}
