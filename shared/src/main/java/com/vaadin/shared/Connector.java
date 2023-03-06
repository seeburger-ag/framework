/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared;

import java.io.Serializable;

/**
 * Interface implemented by all classes that are capable of communicating with
 * the server or the client side.
 * <p>
 * A connector consists of a shared state (server sets the state and
 * automatically communicates changes to the client) and the possibility to do
 * RPC calls either from the server to the client or from the client to the
 * server.
 * </p>
 * <p>
 * No classes should implement this interface directly, client side classes
 * wanting to communicate with server side should implement
 * {@link com.vaadin.client.ServerConnector} and server side classes should
 * implement {@link com.vaadin.server.ClientConnector}.
 * </p>
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public interface Connector extends Serializable {
    /**
     * Returns the id for this connector. This is set by the framework and does
     * not change during the lifetime of a connector.
     *
     * @return The id for the connector.
     */
    public String getConnectorId();

    /**
     * Gets the parent connector of this connector, or <code>null</code> if the
     * connector is not attached to any parent.
     *
     * @return the parent connector, or <code>null</code> if there is no parent.
     */
    public Connector getParent();

}
