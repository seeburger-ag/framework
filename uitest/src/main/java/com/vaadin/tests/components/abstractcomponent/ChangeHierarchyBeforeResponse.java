/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.abstractcomponent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

public class ChangeHierarchyBeforeResponse extends AbstractTestUI {
    private CssLayout layout = new CssLayout() {
        @Override
        public void beforeClientResponse(boolean initial) {
            super.beforeClientResponse(initial);
            if (initial) {
                addComponent(buttonToAdd);
                removeComponent(labelToRemove);
            }
        }
    };

    private Button buttonToAdd = new Button("Added from beforeClientResponse",
            new Button.ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    layout.addComponent(labelToRemove);
                }
            }) {
        @Override
        public void beforeClientResponse(boolean initial) {
            super.beforeClientResponse(initial);
            setCaption("Add label to layout");
        }
    };

    private Label labelToRemove = new Label("Label to remove") {
        int count = 0;

        @Override
        public void beforeClientResponse(boolean initial) {
            super.beforeClientResponse(initial);
            if (initial) {
                count++;
                setValue("Initial count: " + count);
            }
        }
    };

    @Override
    protected void setup(VaadinRequest request) {
        layout.addComponent(labelToRemove);

        addComponent(layout);
    }

}
