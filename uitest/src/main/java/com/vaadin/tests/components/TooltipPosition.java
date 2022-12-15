/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is used for testing that a tooltip is not positioned partially
 * outside the browser window when there is enough space to display it.
 *
 * @author Vaadin Ltd
 */
public class TooltipPosition extends AbstractTestUI {

    public static final int NUMBER_OF_BUTTONS = 5;

    @Override
    protected void setup(VaadinRequest request) {
        // These tooltip delay settings can be removed once #13854 is resolved.
        getTooltipConfiguration().setOpenDelay(0);
        getTooltipConfiguration().setQuickOpenDelay(0);
        getTooltipConfiguration().setCloseTimeout(1000);

        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setHeight(UI.getCurrent().getPage().getBrowserWindowHeight(),
                Unit.PIXELS);
        addComponent(layout);
        for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
            Button button = new Button("Button");
            button.setDescription(generateTooltipText());
            layout.addComponent(button);
        }
    }

    private String generateTooltipText() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            result.append("This is the line ").append(i)
                    .append(" of the long tooltip text.<br>");
        }
        return result.toString();
    }

    @Override
    public String getTestDescription() {
        return "The tooltips of the buttons should not be clipped when there is enough space to display them.";
    }

    @Override
    public Integer getTicketNumber() {
        return 15129;
    }
}
