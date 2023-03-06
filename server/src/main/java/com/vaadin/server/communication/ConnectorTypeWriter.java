/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server.communication;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Collection;

import com.vaadin.server.ClientConnector;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.ui.UI;

import elemental.json.Json;
import elemental.json.JsonException;
import elemental.json.JsonObject;
import elemental.json.impl.JsonUtil;

/**
 * Serializes connector type mappings to JSON.
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public class ConnectorTypeWriter implements Serializable {

    /**
     * Writes a JSON object containing connector-ID-to-type-ID mappings for each
     * dirty Connector in the given UI.
     *
     * @param ui
     *            The {@link UI} containing dirty connectors
     * @param writer
     *            The {@link Writer} used to write the JSON.
     * @param target
     *            The paint target containing the connector type IDs.
     * @throws IOException
     *             If the serialization fails.
     */
    public void write(UI ui, Writer writer, PaintTarget target)
            throws IOException {

        Collection<ClientConnector> dirtyVisibleConnectors = ui
                .getConnectorTracker().getDirtyVisibleConnectors();

        JsonObject connectorTypes = Json.createObject();
        for (ClientConnector connector : dirtyVisibleConnectors) {
            String connectorType = target.getTag(connector);
            try {
                connectorTypes.put(connector.getConnectorId(), connectorType);
            } catch (JsonException e) {
                throw new PaintException(
                        "Failed to send connector type for connector "
                                + connector.getConnectorId() + ": "
                                + e.getMessage(),
                        e);
            }
        }
        writer.write(JsonUtil.stringify(connectorTypes));
    }
}
