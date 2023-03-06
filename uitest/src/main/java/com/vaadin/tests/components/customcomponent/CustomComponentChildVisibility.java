/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.customcomponent;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class CustomComponentChildVisibility extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Label label = new Label("In panel");
        label.setId("label");
        final CustomComponent cc = new CustomComponent(
                new Panel("In CustomComponent", label));

        Button hideButton = new Button("Hide CustomComponent");
        hideButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                cc.setVisible(false);
            }
        });

        addComponent(cc);
        addComponent(hideButton);

    }

    @Override
    protected String getTestDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}
