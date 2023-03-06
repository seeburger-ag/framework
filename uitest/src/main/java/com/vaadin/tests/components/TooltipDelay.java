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

/**
 * Test to see if tooltip delay is working properly.
 *
 * @author Vaadin Ltd
 */
public class TooltipDelay extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest vaadinRequest) {

        Button button = new Button("Expand");
        button.setDescription("Expand");
        addComponent(button);

        getTooltipConfiguration().setOpenDelay(5000);

    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Tooltips should appear with a five second delay.";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 13695;
    }

}