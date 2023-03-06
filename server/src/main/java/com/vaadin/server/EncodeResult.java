/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.io.Serializable;

import elemental.json.JsonValue;

public class EncodeResult implements Serializable {
    private final JsonValue encodedValue;
    private final JsonValue diff;

    public EncodeResult(JsonValue encodedValue) {
        this(encodedValue, null);
    }

    public EncodeResult(JsonValue encodedValue, JsonValue diff) {
        this.encodedValue = encodedValue;
        this.diff = diff;
    }

    public JsonValue getEncodedValue() {
        return encodedValue;
    }

    public JsonValue getDiff() {
        return diff;
    }

    public JsonValue getDiffOrValue() {
        JsonValue diff = getDiff();
        if (diff != null) {
            return diff;
        } else {
            return getEncodedValue();
        }
    }
}
