/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

public class CssLayoutAbsoluteUrl extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Label label = new Label("Hello");
        label.setId("myLabel");
        addComponent(new CssLayout(label) {
            @Override
            protected String getCss(Component c) {
                return "color: blue; background-image: url(\"about:blank\");";
            }
        });
    }

}
