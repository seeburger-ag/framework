/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

/**
 * An extension is an entity that is attached to a Component or another
 * Extension and independently communicates between client and server.
 * <p>
 * An extension can only be attached once. It is not supported to move an
 * extension from one target to another.
 * <p>
 * Extensions can use shared state and RPC in the same way as components.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public interface Extension extends ClientConnector {

    /**
     * Remove this extension from its target. After an extension has been
     * removed, it cannot be attached again.
     */
    void remove();

    /**
     * Sets the parent connector of the connector.
     *
     * This method automatically calls {@link #attach()} if the connector
     * becomes attached to the session.
     * <p>
     * This method is rarely called directly.
     * {@link AbstractClientConnector#addExtension(Extension)} is normally used
     * for adding extensions to a parent and it will call this method
     * implicitly.
     * </p>
     *
     * @param parent
     *            the parent connector
     * @throws IllegalStateException
     *             if a parent is given even though the connector already has a
     *             parent
     */
    public void setParent(ClientConnector parent);

}
