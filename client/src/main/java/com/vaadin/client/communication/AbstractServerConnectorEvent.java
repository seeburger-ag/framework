/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.communication;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.vaadin.client.ServerConnector;

public abstract class AbstractServerConnectorEvent<H extends EventHandler>
        extends GwtEvent<H> {
    private ServerConnector connector;

    protected AbstractServerConnectorEvent() {
    }

    public ServerConnector getConnector() {
        return connector;
    }

    public void setConnector(ServerConnector connector) {
        this.connector = connector;
    }

    /**
     * Sends this event to the given handler.
     *
     * @param handler
     *            The handler to dispatch.
     */
    @Override
    public abstract void dispatch(H handler);
}
