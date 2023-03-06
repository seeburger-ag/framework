/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.communication;

import com.google.gwt.core.client.GWT;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.metadata.Type;
import com.vaadin.shared.communication.URLReference;

import elemental.json.Json;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

public class URLReference_Serializer implements JSONSerializer<URLReference> {

    // setURL() -> uRL as first char becomes lower case...
    private static final String URL_FIELD = "uRL";

    @Override
    public URLReference deserialize(Type type, JsonValue jsonValue,
            ApplicationConnection connection) {
        TranslatedURLReference reference = GWT
                .create(TranslatedURLReference.class);
        reference.setConnection(connection);
        JsonObject json = (JsonObject) jsonValue;
        if (json.hasKey(URL_FIELD)) {
            JsonValue jsonURL = json.get(URL_FIELD);
            String URL = (String) JsonDecoder.decodeValue(
                    new Type(String.class.getName(), null), jsonURL, null,
                    connection);
            reference.setURL(URL);
        }
        return reference;
    }

    @Override
    public JsonValue serialize(URLReference value,
            ApplicationConnection connection) {
        JsonObject json = Json.createObject();
        // No type info required for encoding a String...
        json.put(URL_FIELD,
                JsonEncoder.encode(value.getURL(), null, connection));
        return json;
    }

}
