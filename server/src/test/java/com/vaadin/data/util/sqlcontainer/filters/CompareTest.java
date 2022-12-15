/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer.filters;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.data.util.filter.Compare;

public class CompareTest {

    @Test
    public void testEquals() {
        Compare c1 = new Compare.Equal("prop1", "val1");
        Compare c2 = new Compare.Equal("prop1", "val1");
        Assert.assertTrue(c1.equals(c2));
    }

    @Test
    public void testDifferentTypeEquals() {
        Compare c1 = new Compare.Equal("prop1", "val1");
        Compare c2 = new Compare.Greater("prop1", "val1");
        Assert.assertFalse(c1.equals(c2));
    }

    @Test
    public void testEqualsNull() {
        Compare c1 = new Compare.Equal("prop1", "val1");
        Assert.assertFalse(c1.equals(null));
    }
}
