/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.link;

import java.util.concurrent.atomic.AtomicInteger;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

import elemental.json.JsonArray;

public class LinkInsideDisabledContainer extends AbstractTestUIWithLog {

    private final AtomicInteger clickCounter = new AtomicInteger(0);
    public static final String CLICK_COUNT_TEXT = "Click count: ";

    @Override
    protected void setup(VaadinRequest request) {

        VerticalLayout layout = new VerticalLayout();

        final Link link = new Link(CLICK_COUNT_TEXT + 0,
                new ExternalResource("javascript:__linkClicked()"));

        getPage().getJavaScript().addFunction("__linkClicked",
                new JavaScriptFunction() {

                    @Override
                    public void call(JsonArray arguments) {
                        log(CLICK_COUNT_TEXT + clickCounter.incrementAndGet());
                    }
                });

        final VerticalLayout vlayout = new VerticalLayout();
        vlayout.addComponent(link);
        vlayout.setId("testContainer");
        layout.addComponent(vlayout);

        Button toggleLinkButton = new Button("enable/disable link");
        toggleLinkButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                link.setEnabled(!link.isEnabled());
            }
        });
        layout.addComponent(toggleLinkButton);

        Button toggleContainerButton = new Button("enable/disable container");
        toggleContainerButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                vlayout.setEnabled(!vlayout.isEnabled());
            }
        });
        layout.addComponent(toggleContainerButton);
        addComponent(layout);
    }
}
