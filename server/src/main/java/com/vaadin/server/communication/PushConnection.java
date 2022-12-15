/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server.communication;

import java.io.Serializable;

import com.vaadin.ui.UI;

/**
 * Represents a bidirectional ("push") connection between a single UI and its
 * client-side. A single {@code PushConnection} instance is bound to a UI as
 * long as push is enabled in that UI, even if the actual connection is
 * momentarily dropped either due to a network failure or as a normal part of
 * the transport mechanism.
 * <p>
 * This interface is an internal API, only meant to be used by the framework.
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public interface PushConnection extends Serializable {

    /**
     * Pushes pending state changes and client RPC calls to the client. Can be
     * called even if {@link #isConnected()} is false; the push will be deferred
     * until a connection is available. It is NOT safe to invoke this method if
     * not holding the session lock.
     * <p>
     * This is internal API; please use {@link UI#push()} instead.
     */
    public void push();

    /**
     * Closes the connection. Cannot be called if {@link #isConnected()} is
     * false.
     */
    public void disconnect();

    /**
     * Returns whether this connection is currently open.
     */
    public boolean isConnected();

}
