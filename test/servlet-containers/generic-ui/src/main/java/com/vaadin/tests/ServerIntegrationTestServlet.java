/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import com.vaadin.tests.integration.ServletIntegrationUI;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*" ,name = "IntegrationTestUIProvider", asyncSupported = true, initParams = {
        @WebInitParam(name = "UIProvider", value = "com.vaadin.tests.IntegrationTestUIProvider")})
@VaadinServletConfiguration(ui = ServletIntegrationUI.class, productionMode = false)
public class ServerIntegrationTestServlet extends VaadinServlet {
}
