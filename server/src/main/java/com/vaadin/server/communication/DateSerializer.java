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
import java.util.Date;

import com.vaadin.ui.ConnectorTracker;
import elemental.json.Json;
import elemental.json.JsonValue;

/**
 * Server side serializer/deserializer for java.util.Date
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class DateSerializer implements JSONSerializer<Date> {

    @Override
    public Date deserialize(Type type, JsonValue jsonValue,
            ConnectorTracker connectorTracker) {
        return new Date((long) jsonValue.asNumber());
    }

    @Override
    public JsonValue serialize(Date value, ConnectorTracker connectorTracker) {
        return Json.create(value.getTime());
    }

}
