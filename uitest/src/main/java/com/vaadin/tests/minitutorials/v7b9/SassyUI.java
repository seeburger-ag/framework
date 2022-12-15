/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7b9;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("sassy")
public class SassyUI extends UI {
    @Override
    public void init(VaadinRequest request) {
        Button b = new Button("Reindeer");
        Layout layout = new VerticalLayout();
        layout.addComponent(b);

        b = new Button("important");
        b.addStyleName("important");
        layout.addComponent(b);

        b = new Button("More important");
        b.setPrimaryStyleName("my-button");
        layout.addComponent(b);

        setContent(layout);
    }
}
