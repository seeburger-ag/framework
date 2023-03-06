/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.panel;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class PanelHTMLCaption extends AbstractTestUI {
    public static final String caption = "<b> <div id='divId'>BOLD CAPTION</div></b>";
    private Panel panel;

    @Override
    protected void setup(VaadinRequest request) {
        panel = new Panel();
        panel.setId("panelId");
        panel.setWidth("200px");
        panel.setHeight("200px");

        panel.setCaption(caption);
        panel.setCaptionAsHtml(false);

        panel.setContent(new VerticalLayout());

        addComponent(panel);
        Button changeCaptionFormat = new Button(
                "Set Caption as HTML", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                panel.setCaptionAsHtml(true);
            }
        });

        changeCaptionFormat.setId("buttonId");
        addComponent(changeCaptionFormat);
    }
}