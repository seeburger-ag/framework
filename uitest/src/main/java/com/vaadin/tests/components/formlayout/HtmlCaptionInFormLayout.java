/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.formlayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class HtmlCaptionInFormLayout extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
        final TextField asHtml = new TextField("Contains <b>HTML</b>");
        asHtml.setCaptionAsHtml(true);

        final TextField asText = new TextField("Contains <b>HTML</b>");

        addComponent(new FormLayout(asHtml, asText));

        addComponent(new Button("Toggle", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                asHtml.setCaptionAsHtml(!asHtml.isCaptionAsHtml());
                asText.setCaptionAsHtml(!asText.isCaptionAsHtml());
            }
        }));
    }
}
