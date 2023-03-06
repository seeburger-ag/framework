/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tooltip;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;

public class TooltipAndJavascript extends AbstractTestUI {

    @JavaScript("tooltipandjavascript.js")
    public static class MyButton extends Button {

    }

    @Override
    protected void setup(VaadinRequest request) {
        MyButton b = new MyButton();
        b.setCaption("Hover for tooltip");
        b.setDescription("Tooltip for the button");
        addComponent(b);
    }

    @Override
    protected String getTestDescription() {
        return "Hover the button for a tooltip. It should be styled correctly";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14028;
    }

}
