/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.integration.websocket.jsr356;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assume;

import com.vaadin.tests.integration.websocket.ServletIntegrationWebsocketIT;

public class ServletIntegrationJSR356WebsocketIT
        extends ServletIntegrationWebsocketIT {
    // Uses the test method declared in the super class

    private static final Set<String> nonJSR356Servers = new HashSet<String>();

    static {
        nonJSR356Servers.add("jetty8");
    }

    @Override
    public void setup() throws Exception {
        Assume.assumeFalse("This server does not support JSR356",
                nonJSR356Servers.contains(System.getProperty("server-name")));

        super.setup();
    }

    @Override
    protected String getTestPath() {
        return super.getTestPath().replace("/run/", "/run-jsr356/");
    }
}
