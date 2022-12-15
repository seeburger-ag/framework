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
import java.util.HashSet;
import java.util.Set;

import com.vaadin.server.ClientConnector;
import com.vaadin.server.PaintException;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.ui.UI;

import elemental.json.Json;
import elemental.json.JsonException;
import elemental.json.JsonObject;
import elemental.json.impl.JsonUtil;

/**
 * Serializes {@link SharedState shared state} changes to JSON.
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public class SharedStateWriter implements Serializable {

    /**
     * Writes a JSON object containing the pending state changes of the dirty
     * connectors of the given UI.
     *
     * @param ui
     *            The UI whose state changes should be written.
     * @param writer
     *            The writer to use.
     * @return a set of connector ids with state changes
     * @throws IOException
     *             If the serialization fails.
     */
    public Set<String> write(UI ui, Writer writer) throws IOException {

        Collection<ClientConnector> dirtyVisibleConnectors = ui
                .getConnectorTracker().getDirtyVisibleConnectors();

        Set<String> writtenConnectors = new HashSet<String>();
        JsonObject sharedStates = Json.createObject();
        for (ClientConnector connector : dirtyVisibleConnectors) {
            // encode and send shared state
            String connectorId = connector.getConnectorId();
            try {
                JsonObject stateJson = connector.encodeState();

                if (stateJson != null && stateJson.keys().length != 0) {
                    sharedStates.put(connectorId, stateJson);
                    writtenConnectors.add(connectorId);
                }
            } catch (JsonException e) {
                throw new PaintException(
                        "Failed to serialize shared state for connector "
                                + connector.getClass().getName() + " ("
                                + connectorId + "): " + e.getMessage(),
                        e);
            }
        }
        writer.write(JsonUtil.stringify(sharedStates));

        return writtenConnectors;
    }
}
