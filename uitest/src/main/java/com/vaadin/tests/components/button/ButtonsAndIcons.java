/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.button;

import com.vaadin.server.ThemeResource;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Button;
import com.vaadin.ui.NativeButton;

public class ButtonsAndIcons extends TestBase {

    @Override
    protected String getDescription() {
        return "The first button has text and an icon, the second only text and the third only an icon.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 3031;
    }

    @Override
    protected void setup() {
        Button b = new Button("Text and icon");
        b.setIcon(new ThemeResource("../runo/icons/16/ok.png"));

        addComponent(b);

        b = new Button("Only text");

        addComponent(b);
        b = new Button((String) null);
        b.setIcon(new ThemeResource("../runo/icons/16/ok.png"));

        addComponent(b);

        b = new NativeButton("Text and icon");
        b.setIcon(new ThemeResource("../runo/icons/16/ok.png"));

        addComponent(b);

        b = new NativeButton("Only text");

        addComponent(b);
        b = new NativeButton(null);
        b.setIcon(new ThemeResource("../runo/icons/16/ok.png"));

        addComponent(b);
    }

}
