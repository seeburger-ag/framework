/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layoutmanager;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.server.LayoutDuringStateUpdateComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@Widgetset(TestingWidgetSet.NAME)
public class LayoutDuringStateUpdate extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        // delay adding of the component to ensure unrelated layouting calls
        // don't interfere with the test
        addComponent(new Button("Add component", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent e) {
                addComponent(new LayoutDuringStateUpdateComponent());
            }
        }));
    }

}
