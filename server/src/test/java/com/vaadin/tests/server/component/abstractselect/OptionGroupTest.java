/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.abstractselect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.vaadin.ui.OptionGroup;

public class OptionGroupTest {

    private OptionGroup optionGroup;

    @Before
    public void setup() {
        optionGroup = new OptionGroup();
    }

    @Test
    public void itemsAreAdded() {
        optionGroup.addItems("foo", "bar");

        Collection<?> itemIds = optionGroup.getItemIds();

        assertEquals(2, itemIds.size());
        assertTrue(itemIds.contains("foo"));
        assertTrue(itemIds.contains("bar"));
    }
}
