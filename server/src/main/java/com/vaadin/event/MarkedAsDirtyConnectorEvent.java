/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.event;

import com.vaadin.server.ClientConnector;
import com.vaadin.ui.UI;

/**
 * Event which is fired for all registered MarkDirtyListeners when a connector
 * is marked as dirty.
 *
 * @since 7.7.14
 */
public class MarkedAsDirtyConnectorEvent extends ConnectorEvent {

    private final UI ui;

    public MarkedAsDirtyConnectorEvent(ClientConnector source, UI ui) {
        super(source);
        this.ui = ui;
    }

    /**
     * Get the UI for which the connector event was fired
     *
     * @return target ui for event
     */
    public UI getUi() {
        return ui;
    }
}
