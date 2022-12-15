/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.debug;

import org.atmosphere.util.Version;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

/**
 * Test UI for PUSH version string in debug window.
 *
 * @author Vaadin Ltd
 */
public class PushVersionInfo extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        if (request.getParameter("enablePush") != null) {
            getPushConfiguration().setPushMode(PushMode.AUTOMATIC);
            Label label = new Label(Version.getRawVersion());
            label.addStyleName("atmosphere-version");
            addComponent(label);
        }
    }

    @Override
    public String getDescription() {
        return "Debug window shows Push version in info Tab.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14904;
    }
}
