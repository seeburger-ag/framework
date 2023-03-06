/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.rpclogger;

import com.vaadin.server.ClientConnector;
import com.vaadin.server.ServerRpcMethodInvocation;
import com.vaadin.server.communication.ServerRpcHandler;
import com.vaadin.shared.communication.LegacyChangeVariablesInvocation;
import com.vaadin.ui.UI;

public class LoggingServerRpcHandler extends ServerRpcHandler {

    @Override
    protected void handleInvocation(UI ui, ClientConnector connector,
            LegacyChangeVariablesInvocation legacyInvocation) {
        ((RPCLoggerUI) ui).recordInvocation(connector, legacyInvocation);
        super.handleInvocation(ui, connector, legacyInvocation);
    }

    @Override
    protected void handleInvocation(UI ui, ClientConnector connector,
            ServerRpcMethodInvocation invocation) {
        ((RPCLoggerUI) ui).recordInvocation(connector, invocation);
        super.handleInvocation(ui, connector, invocation);
    }

}
