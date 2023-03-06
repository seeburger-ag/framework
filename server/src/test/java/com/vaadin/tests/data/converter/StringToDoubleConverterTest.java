/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.converter;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.data.util.converter.StringToDoubleConverter;

public class StringToDoubleConverterTest {

    StringToDoubleConverter converter = new StringToDoubleConverter();

    @Test
    public void testNullConversion() {
        Assert.assertEquals(null,
                converter.convertToModel(null, Double.class, null));
    }

    @Test
    public void testEmptyStringConversion() {
        Assert.assertEquals(null,
                converter.convertToModel("", Double.class, null));
    }

    @Test
    public void testValueConversion() {
        Double value = converter.convertToModel("10", Double.class, null);
        Assert.assertEquals(10.0d, value, 0.01d);
    }
}
