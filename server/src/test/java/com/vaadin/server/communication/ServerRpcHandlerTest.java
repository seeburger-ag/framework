/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import org.junit.Test;
import org.mockito.Mockito;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.tests.util.AlwaysLockedVaadinSession;
import com.vaadin.ui.UI;

import elemental.json.Json;
import elemental.json.JsonArray;

public class ServerRpcHandlerTest {

    public static class TestUI extends UI {

        @Override
        protected void init(VaadinRequest request) {

        }

    }

    @Test
    public void handleUnknownConnector() {
        ServerRpcHandler rpcHandler = new ServerRpcHandler();
        JsonArray invocation = Json.createArray();
        invocation.set(0, "12");
        invocation.set(1, "someInterface");
        invocation.set(2, "someMethod");
        JsonArray params = Json.createArray();
        invocation.set(3, params);

        JsonArray invocationData = Json.createArray();
        invocationData.set(0, invocation);

        AlwaysLockedVaadinSession s = new AlwaysLockedVaadinSession(
                Mockito.mock(VaadinService.class));
        TestUI ui = new TestUI();
        ui.doInit(Mockito.mock(VaadinRequest.class), 1, null);
        ui.setSession(s);
        s.addUI(ui);
        rpcHandler.handleInvocations(ui, 1, invocationData);

        // This only tests that an invocation for a non-existant connector does
        // not cause any exceptions
    }
}
