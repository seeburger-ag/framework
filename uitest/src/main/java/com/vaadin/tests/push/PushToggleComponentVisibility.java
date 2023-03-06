/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Push
@Widgetset("com.vaadin.DefaultWidgetSet")
public class PushToggleComponentVisibility extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout mainLayout = new VerticalLayout();
        setContent(mainLayout);

        final Label label = new Label("Please wait");
        label.setId("label");
        label.setVisible(false);
        mainLayout.addComponent(label);

        final Button button = new Button("Hide me for 3 seconds");
        button.setId("hide");
        button.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event1) {
                button.setVisible(false);
                label.setVisible(true);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        button.getUI().access(new Runnable() {
                            @Override
                            public void run() {
                                button.setVisible(true);
                                label.setVisible(false);
                                button.getUI().push();
                            }
                        });
                    }
                }).start();
            }
        });
        mainLayout.addComponent(button);
    }

}
