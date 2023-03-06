/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui.ui;

/**
 * Transport modes for Push
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public enum Transport {
    /**
     * Websockets
     */
    WEBSOCKET("websocket"),
    /**
     * Websockets for server to client, XHR for client to server
     *
     * @since 7.6
     */
    WEBSOCKET_XHR("websocket-xhr"),
    /**
     * HTTP streaming
     *
     * @deprecated Use the more reliable {@link Transport#LONG_POLLING} instead.
     */
    @Deprecated
    STREAMING("streaming"),
    /**
     * HTTP long polling
     */
    LONG_POLLING("long-polling");

    private String identifier;

    private Transport(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    /**
     * Returns a Transport by its identifier. Returns null if no value is found
     * for the given identifier.
     *
     * @since 7.3.10
     */
    public static Transport getByIdentifier(String identifier) {
        for (Transport t : values()) {
            if (t.getIdentifier().equals(identifier)) {
                return t;
            }
        }
        return null;
    }
}
