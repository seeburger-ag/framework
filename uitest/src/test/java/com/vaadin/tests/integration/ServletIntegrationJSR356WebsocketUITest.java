/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.integration;

public class ServletIntegrationJSR356WebsocketUITest
        extends AbstractServletIntegrationTest {
    // Uses the test method declared in the super class

    @Override
    protected String getDeploymentPath(Class<?> uiClass) {
        return super.getDeploymentPath(uiClass).replace("/run/",
                "/run-jsr356/");
    }

    @Override
    protected Class<?> getUIClass() {
        return ServletIntegrationWebsocketUI.class;
    }
}
