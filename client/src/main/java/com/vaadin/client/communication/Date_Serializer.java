/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.communication;

import java.util.Date;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.metadata.Type;

import elemental.json.Json;
import elemental.json.JsonValue;

/**
 * Client side serializer/deserializer for java.util.Date
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class Date_Serializer implements JSONSerializer<Date> {

    @Override
    public Date deserialize(Type type, JsonValue jsonValue,
            ApplicationConnection connection) {
        return new Date((long) jsonValue.asNumber());
    }

    @Override
    public JsonValue serialize(Date value, ApplicationConnection connection) {
        return Json.create(value.getTime());
    }

}
