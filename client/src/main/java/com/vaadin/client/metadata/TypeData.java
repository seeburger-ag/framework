/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.metadata;

public class TypeData {

    public static Type getType(Class<?> type) {
        return TypeDataStore.getType(type);
    }

    public static Class<?> getClass(String identifier) throws NoDataException {
        return TypeDataStore.getClass(identifier);
    }

    public static boolean hasIdentifier(String identifier) {
        return TypeDataStore.hasIdentifier(identifier);
    }
}
