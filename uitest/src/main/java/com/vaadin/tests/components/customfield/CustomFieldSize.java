/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.customfield;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class CustomFieldSize extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.setWidth("50px");

        layout.addComponent(new TextField());

        layout.addComponent(new CustomField<String>() {

            @Override
            protected Component initContent() {
                return new TextField();
            }

            @Override
            public Class<? extends String> getType() {
                return String.class;
            }

        });
    }

    @Override
    protected String getTestDescription() {
        return "Any part of a TextField wrapped in a CustomField should not be cut off even when the dimensions of the TextField exceed those of the CustomField";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12482;
    }

}
