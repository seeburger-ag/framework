/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.applicationservlet;

import com.vaadin.launcher.ApplicationRunnerServlet;
import com.vaadin.launcher.CustomDeploymentConfiguration;
import com.vaadin.launcher.CustomDeploymentConfiguration.Conf;
import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

@CustomDeploymentConfiguration({
        @Conf(name = "customParam", value = "customValue"),
        @Conf(name = "resourceCacheTime", value = "3599") })
public class CustomDeploymentConf extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        DeploymentConfiguration deploymentConfiguration = getSession()
                .getService().getDeploymentConfiguration();
        addComponent(new Label("Resource cache time: "
                + deploymentConfiguration.getResourceCacheTime()));
        addComponent(new Label("Custom config param: " + deploymentConfiguration
                .getApplicationOrSystemProperty("customParam", null)));
    }

    @Override
    protected String getTestDescription() {
        return "Demonstrates the @"
                + CustomDeploymentConfiguration.class.getSimpleName()
                + " feature that allows customizing the effective deployment configuration for test UIs run through "
                + ApplicationRunnerServlet.class.getSimpleName() + ".";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(14215);
    }

}
