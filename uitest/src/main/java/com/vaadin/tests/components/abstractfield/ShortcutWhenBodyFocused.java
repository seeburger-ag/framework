/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.abstractfield;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class ShortcutWhenBodyFocused extends AbstractTestUIWithLog {
    @Override
    protected void setup(VaadinRequest request) {
        Button b = new Button("Hello", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                log("Hello clicked");
            }
        });
        b.setClickShortcut(KeyCode.A);
        addComponent(b);

        getPage().getStyles().add("body { width: 50% !important}");
    }
}
