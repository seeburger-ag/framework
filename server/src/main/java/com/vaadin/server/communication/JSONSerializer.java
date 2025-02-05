/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import java.lang.reflect.Type;

import com.vaadin.ui.ConnectorTracker;
import elemental.json.JsonValue;

/**
 * Implementors of this interface knows how to serialize an Object of a given
 * type to JSON and how to deserialize the JSON back into an object.
 * <p>
 * The {@link #serialize(Object, ConnectorTracker)} and
 * {@link #deserialize(Type, JsonValue, ConnectorTracker)} methods must be
 * symmetric so they can be chained and produce the original result (or an equal
 * result).
 * <p>
 * Each {@link JSONSerializer} implementation can handle an object of a single
 * type.
 * <p>
 * This is the server side interface, see
 * com.vaadin.client.communication.JSONSerializer for the client side interface.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public interface JSONSerializer<T> {
    /**
     * Creates and deserializes an object received from the client. Must be
     * compatible with {@link #serialize(Object, ConnectorTracker)} and also
     * with the client side com.vaadin.client.communication.JSONSerializer.
     *
     * @param type
     *            The expected return type
     * @param jsonValue
     *            the value from the JSON
     * @param connectorTracker
     *            the connector tracker instance for the UI
     * @return A deserialized object
     */
    T deserialize(Type type, JsonValue jsonValue,
            ConnectorTracker connectorTracker);

    /**
     * Serialize the given object into JSON. Must be compatible with
     * {@link #deserialize(Type, JsonValue, ConnectorTracker)} and the client
     * side com.vaadin.client.communication.JSONSerializer
     *
     * @param value
     *            The object to serialize
     * @param connectorTracker
     *            The connector tracker instance for the UI
     * @return A JSON serialized version of the object
     */
    JsonValue serialize(T value, ConnectorTracker connectorTracker);

}
