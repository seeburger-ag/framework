/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.rpclogger;

import com.vaadin.server.communication.ServerRpcHandler;
import com.vaadin.server.communication.UidlRequestHandler;

public class LoggingUidlRequestHandler extends UidlRequestHandler {

    @Override
    protected ServerRpcHandler createRpcHandler() {
        return new LoggingServerRpcHandler();
    }

}
