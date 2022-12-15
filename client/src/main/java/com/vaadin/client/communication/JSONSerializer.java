/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.communication;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.metadata.Type;
import elemental.json.JsonValue;

/**
 * Implementors of this interface knows how to serialize an Object of a given
 * type to JSON and how to deserialize the JSON back into an object.
 * <p>
 * The {@link #serialize(Object, ApplicationConnection)} and
 * {@link #deserialize(Type, JsonValue, ApplicationConnection)} methods must be
 * symmetric so they can be chained and produce the original result (or an equal
 * result).
 * <p>
 * Each {@link JSONSerializer} implementation can handle an object of a single
 * type - see {@link Type#findSerializer()}.
 * <p>
 * This is the client side interface, see
 * com.vaadin.server.communication.JSONSerializer for the server side interface.
 *
 * @since 7.0
 */
public interface JSONSerializer<T> {

    /**
     * Creates and deserializes an object received from the server. Must be
     * compatible with {@link #serialize(Object, ApplicationConnection)} and
     * also with the server side JsonCodec.encode method.
     *
     * @param type
     *            the type to deserialize
     * @param jsonValue
     *            JSON map from property name to property value
     * @param connection
     *            the application connection providing the context
     *
     * @return A deserialized object
     */
    T deserialize(Type type, JsonValue jsonValue,
            ApplicationConnection connection);

    /**
     * Serialize the given object into JSON. Must be compatible with
     * {@link #deserialize(Type, JsonValue, ApplicationConnection)} and also
     * with the server side JsonCodec.decodeCustomType method.
     *
     * @param value
     *            The object to serialize
     * @param connection
     *            the application connection providing the context
     * @return A JSON serialized version of the object
     */
    JsonValue serialize(T value, ApplicationConnection connection);

}
