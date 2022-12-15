/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.abstractcomponent;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.server.UseStateFromHierachyComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;

@Widgetset(TestingWidgetSet.NAME)
public class UseStateFromHierachy extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final UseStateFromHierachyComponent component = new UseStateFromHierachyComponent();
        component.setContent(new Label("Content child"));

        addComponent(component);
        addComponent(new Button("Remove component", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                removeComponent(component);
            }
        }));
    }

    @Override
    protected String getTestDescription() {
        return "Tests that shared state and connector hierarchy is consistent when removing components from the hierachy";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(10151);
    }

}
