/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.button;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class ButtonHtml extends TestBase {

    @Override
    protected void setup() {
        Button b = new Button("<b>Plain text button</b>");
        addComponent(b);

        b = new Button(
                "<span style=\"color: red; font-weight: bold;\">HTML</span> button");
        b.setHtmlContentAllowed(true);
        addComponent(b);

        final Button swapButton = new Button("<i>Swap button<i>");
        swapButton.addListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                swapButton.setHtmlContentAllowed(
                        !swapButton.isHtmlContentAllowed());
            }
        });
        addComponent(swapButton);
    }

    @Override
    protected String getDescription() {
        return "Verify that Button HTML rendering works";
    }

    @Override
    protected Integer getTicketNumber() {
        return 8663;
    }
}
