/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.checkbox;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.CheckBox;

public class CheckboxContextClick extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        final CheckBox cb = new CheckBox("Right-click me", true);
        cb.addContextClickListener(
                new ContextClickEvent.ContextClickListener() {
                    @Override
                    public void contextClick(ContextClickEvent event) {
                        log("checkbox context clicked");
                    }
                });

        addComponent(cb);
    }

}
