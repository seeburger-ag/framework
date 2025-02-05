/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.junit.Test;

import com.vaadin.server.KeyMapper;

public class KeyMapperTest {

    @Test
    public void testAdd() {
        KeyMapper<Object> mapper = new KeyMapper<Object>();
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        // Create new ids
        String key1 = mapper.key(o1);
        String key2 = mapper.key(o2);
        String key3 = mapper.key(o3);

        assertEquals(mapper.get(key1), o1);
        assertEquals(mapper.get(key2), o2);
        assertEquals(mapper.get(key3), o3);
        assertNotSame(key1, key2);
        assertNotSame(key1, key3);
        assertNotSame(key2, key3);

        assertSize(mapper, 3);

        // Key should not add if there already is a mapping
        assertEquals(mapper.key(o3), key3);
        assertSize(mapper, 3);

        // Remove -> add should return a new key
        mapper.remove(o1);
        String newkey1 = mapper.key(o1);
        assertNotSame(key1, newkey1);

    }

    @Test
    public void testRemoveAll() {
        KeyMapper<Object> mapper = new KeyMapper<Object>();
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        // Create new ids
        mapper.key(o1);
        mapper.key(o2);
        mapper.key(o3);

        assertSize(mapper, 3);
        mapper.removeAll();
        assertSize(mapper, 0);

    }

    @Test
    public void testRemove() {
        KeyMapper<Object> mapper = new KeyMapper<Object>();
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        // Create new ids
        mapper.key(o1);
        mapper.key(o2);
        mapper.key(o3);

        assertSize(mapper, 3);
        mapper.remove(o1);
        assertSize(mapper, 2);
        mapper.key(o1);
        assertSize(mapper, 3);
        mapper.remove(o1);
        assertSize(mapper, 2);

        mapper.remove(o2);
        mapper.remove(o3);
        assertSize(mapper, 0);

    }

    private void assertSize(KeyMapper<?> mapper, int i) {
        try {
            Field f1 = KeyMapper.class.getDeclaredField("objectKeyMap");
            Field f2 = KeyMapper.class.getDeclaredField("keyObjectMap");
            f1.setAccessible(true);
            f2.setAccessible(true);

            HashMap<?, ?> h1 = (HashMap<?, ?>) f1.get(mapper);
            HashMap<?, ?> h2 = (HashMap<?, ?>) f2.get(mapper);

            assertEquals(i, h1.size());
            assertEquals(i, h2.size());
        } catch (Throwable t) {
            t.printStackTrace();
            fail();
        }
    }
}
