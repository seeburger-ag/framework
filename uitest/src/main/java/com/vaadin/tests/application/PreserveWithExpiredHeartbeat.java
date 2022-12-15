/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.launcher.CustomDeploymentConfiguration;
import com.vaadin.launcher.CustomDeploymentConfiguration.Conf;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

@PreserveOnRefresh
@CustomDeploymentConfiguration({
        @Conf(name = "heartbeatInterval", value = "5") })
public class PreserveWithExpiredHeartbeat extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Label label = new Label("UI with id " + getUIId() + " in session "
                + getSession().getSession().getId());
        label.setId("idLabel");
        addComponent(label);
    }
}
