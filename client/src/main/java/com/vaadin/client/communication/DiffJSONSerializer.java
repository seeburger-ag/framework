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

public interface DiffJSONSerializer<T> extends JSONSerializer<T> {
    /**
     * Update the target object in place based on the passed JSON data.
     *
     * @param target
     * @param jsonValue
     * @param connection
     */
    public void update(T target, Type type, JsonValue jsonValue,
            ApplicationConnection connection);
}
