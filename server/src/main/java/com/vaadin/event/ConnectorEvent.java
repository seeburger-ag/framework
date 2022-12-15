/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.event;

import java.util.EventObject;

import com.vaadin.server.ClientConnector;

public abstract class ConnectorEvent extends EventObject {
    public ConnectorEvent(ClientConnector source) {
        super(source);
    }

    public ClientConnector getConnector() {
        return (ClientConnector) getSource();
    }
}
