/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.richtextarea;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.progressindicator.ProgressIndicatorServerRpc;
import com.vaadin.tests.components.AbstractComponentTest;
import com.vaadin.tests.components.AbstractTestCase;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.RichTextArea;

public class RichTextAreaUpdateWhileTyping extends AbstractTestUI {

    private RichTextArea rta;

    @Override
    protected void setup(VaadinRequest request) {

        // Progress indicator for changing the value of the RTA
        ProgressIndicator pi = new ProgressIndicator() {
            {
                registerRpc(new ProgressIndicatorServerRpc() {

                    @Override
                    public void poll() {
                        rta.markAsDirty();
                    }
                });
            }
        };
        pi.setHeight("0px");
        addComponent(pi);

        rta = new RichTextArea();
        rta.setId("rta");
        rta.setImmediate(true);
        addComponent(rta);
    }

    @Override
    protected String getTestDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Integer getTicketNumber() {
        return 11741;
    }
}
