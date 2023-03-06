/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class TestForWindowOpen extends CustomComponent {

    public TestForWindowOpen() {

        final VerticalLayout main = new VerticalLayout();
        setCompositionRoot(main);

        main.addComponent(
                new Button("Open in this window", new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        UI.getCurrent().getPage()
                                .setLocation("http://www.google.com");

                    }

                }));

        main.addComponent(new Button("Open in target \"mytarget\"",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        UI.getCurrent().getPage().open("http://www.google.com",
                                "mytarget");

                    }

                }));

        main.addComponent(new Button("Open in target \"secondtarget\"",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        UI.getCurrent().getPage().open("http://www.google.com",
                                "secondtarget");

                    }

                }));

    }

}
