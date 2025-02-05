/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client.minitutorials.v7a3;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ClientSideModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final TextBox nameField = new TextBox();
        nameField.setText("GWT User");
        final Button button = new Button("Check");

        VerticalPanel vp = new VerticalPanel();
        vp.add(nameField);
        vp.add(button);
        RootPanel.get().add(vp);

        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if ("GWT User".equals(nameField.getText())) {
                    Window.alert("User OK");
                } else {
                    Window.alert("Unauthorized user");
                }
            }
        });
    }
}
