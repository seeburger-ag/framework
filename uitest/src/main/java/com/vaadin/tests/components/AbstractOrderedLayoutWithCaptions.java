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
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Test to see if AbstractOrderedLayout displays captions correctly with
 * expanding ratios.
 *
 * @author Vaadin Ltd
 */
public class AbstractOrderedLayoutWithCaptions extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();

        TextField textField = new TextField("Input Text:");
        Label label1 = new Label("LABEL 1");
        Label label2 = new Label("LABEL 2");

        layout.addComponent(textField);

        layout.addComponent(label1);
        layout.setExpandRatio(label1, 1.0f);

        layout.addComponent(label2);

        Panel containingPanel = new Panel(layout);
        containingPanel.setHeight("200px");
        addComponent(containingPanel);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Test to see if AbstractOrderedLayout calculates captions correctly.";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 13741;
    }
}
