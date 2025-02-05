/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.tests.components.orderedlayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ErrorIndicator extends AbstractTestUI {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();

        TextField inVertical = new TextField();
        inVertical.setRequired(true);
        inVertical.setRequiredError("Vertical layout tooltip");
        inVertical.setCaption("Vertical layout caption");

        layout.addComponent(inVertical);
        addComponent(layout);

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        TextField inHorizontal = new TextField();
        inHorizontal.setRequired(true);
        inHorizontal.setRequiredError("Horizontal layout tooltip");
        inHorizontal.setCaption("Horizontal layout caption");

        horizontalLayout.addComponent(inHorizontal);
        layout.addComponent(horizontalLayout);
        getTooltipConfiguration().setOpenDelay(0);
        getTooltipConfiguration().setQuickOpenDelay(0);
        getTooltipConfiguration().setCloseTimeout(1000);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Show tooltip for caption and required indicator";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 10046;
    }

}
