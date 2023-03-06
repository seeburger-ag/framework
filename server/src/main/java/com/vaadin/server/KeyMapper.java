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
import java.util.HashMap;

/**
 * <code>KeyMapper</code> is the simple two-way map for generating textual keys
 * for objects and retrieving the objects later with the key.
 *
 * @author Vaadin Ltd.
 * @since 3.0
 */
public class KeyMapper<V> implements Serializable {

    private int lastKey = 0;

    private final HashMap<V, String> objectKeyMap = new HashMap<V, String>();

    private final HashMap<String, V> keyObjectMap = new HashMap<String, V>();

    /**
     * Gets key for an object.
     *
     * @param o
     *            the object.
     */
    public String key(V o) {

        if (o == null) {
            return "null";
        }

        // If the object is already mapped, use existing key
        String key = objectKeyMap.get(o);
        if (key != null) {
            return key;
        }

        // If the object is not yet mapped, map it
        key = String.valueOf(++lastKey);
        objectKeyMap.put(o, key);
        keyObjectMap.put(key, o);

        return key;
    }

    /**
     * Retrieves object with the key.
     *
     * @param key
     *            the name with the desired value.
     * @return the object with the key.
     */
    public V get(String key) {
        return keyObjectMap.get(key);
    }

    /**
     * Removes object from the mapper.
     *
     * @param removeobj
     *            the object to be removed.
     */
    public void remove(V removeobj) {
        final String key = objectKeyMap.get(removeobj);

        if (key != null) {
            objectKeyMap.remove(removeobj);
            keyObjectMap.remove(key);
        }
    }

    /**
     * Removes all objects from the mapper.
     */
    public void removeAll() {
        objectKeyMap.clear();
        keyObjectMap.clear();
    }

    /**
     * Checks if the given key is mapped to an object.
     *
     * @since 7.7
     *
     * @param key
     *            the key to check
     * @return <code>true</code> if the key is currently mapped,
     *         <code>false</code> otherwise
     */
    public boolean containsKey(String key) {
        return keyObjectMap.containsKey(key);
    }
}
