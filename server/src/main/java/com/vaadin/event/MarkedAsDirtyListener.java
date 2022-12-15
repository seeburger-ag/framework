/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.event;

/**
 * An interface used for listening to marked as dirty events.
 *
 * @since 7.7.14
 */
public interface MarkedAsDirtyListener extends ConnectorEventListener {

    /**
     * Method called when a client connector has been marked as dirty.
     *
     * @param event
     *            marked as dirty connector event object
     */
    void connectorMarkedAsDirty(MarkedAsDirtyConnectorEvent event);
}
