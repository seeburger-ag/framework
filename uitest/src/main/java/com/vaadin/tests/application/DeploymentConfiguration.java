/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import java.util.Properties;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

public class DeploymentConfiguration extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Properties params = getSession().getConfiguration().getInitParameters();
        getLayout().setMargin(new MarginInfo(true, false, false, false));

        for (Object key : params.keySet()) {
            addComponent(
                    new Label(key + ": " + params.getProperty((String) key)));
        }
    }

    @Override
    protected String getTestDescription() {
        return "Init parameters:";
    }
}
