/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.communication;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.vaadin.shared.Connector;
import com.vaadin.shared.annotations.NoLayout;

/**
 * Interface to be implemented by all shared state classes used to communicate
 * basic information about a {@link Connector} from server to client.
 *
 * Shared state classes have to be declared in shared package to be accessible
 * both for server and client code.
 *
 * Shared state objects are only sent from the server to the client, and any
 * modifications from the client should be performed via an RPC call that
 * modifies the authoritative state on the server.
 *
 * A shared state class should be a bean with getters and setters for each
 * field. Supported data types are simple Java types, other beans and maps and
 * arrays of these.
 *
 * On the client side the connector should override
 * {@link com.vaadin.client.ui.AbstractConnector#getState()} to return the
 * correct state type. This automatically causes a correct state object to be
 * created.
 *
 * Subclasses of a {@link Connector} using shared state should also provide a
 * subclass of the shared state class of the parent class to extend the state. A
 * single {@link Connector} can only have one shared state object.
 *
 * @since 7.0
 */
public class SharedState implements Serializable {

    /**
     * The automatically managed resources used by the connector.
     *
     * @see com.vaadin.server.AbstractClientConnector#setResource(String,
     *      com.vaadin.server.Resource)
     * @see com.vaadin.client.ui.AbstractConnector#getResourceUrl(String)
     */
    public Map<String, URLReference> resources = new HashMap<String, URLReference>();

    public boolean enabled = true;
    /**
     * A set of event identifiers with registered listeners.
     */
    @NoLayout
    public Set<String> registeredEventListeners = null;

}
