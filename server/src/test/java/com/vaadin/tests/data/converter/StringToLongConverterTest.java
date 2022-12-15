/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.converter;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.ReverseConverter;
import com.vaadin.data.util.converter.StringToLongConverter;

public class StringToLongConverterTest {

    StringToLongConverter converter = new StringToLongConverter();
    Converter<Long, String> reverseConverter = new ReverseConverter<Long, String>(
            converter);

    @Test
    public void testNullConversion() {
        Assert.assertEquals(null,
                converter.convertToModel(null, Long.class, null));
    }

    @Test
    public void testReverseNullConversion() {
        Assert.assertEquals(null,
                reverseConverter.convertToModel(null, String.class, null));
    }

    @Test
    public void testEmptyStringConversion() {
        Assert.assertEquals(null,
                converter.convertToModel("", Long.class, null));
    }

    @Test
    public void testValueConversion() {
        Assert.assertEquals(Long.valueOf(10),
                converter.convertToModel("10", Long.class, null));
    }

    @Test
    public void testReverseValueConversion() {
        Assert.assertEquals(
                reverseConverter.convertToModel(10L, String.class, null), "10");
    }

    @Test
    public void testExtremeLongValueConversion() {
        long l = converter.convertToModel("9223372036854775807", Long.class,
                null);
        Assert.assertEquals(Long.MAX_VALUE, l);
        l = converter.convertToModel("-9223372036854775808", Long.class, null);
        Assert.assertEquals(Long.MIN_VALUE, l);
    }

    @Test
    public void testExtremeReverseLongValueConversion() {
        String str = reverseConverter.convertToModel(Long.MAX_VALUE,
                String.class, Locale.ENGLISH);
        Assert.assertEquals("9,223,372,036,854,775,807", str);
        str = reverseConverter.convertToModel(Long.MIN_VALUE, String.class,
                Locale.ENGLISH);
        Assert.assertEquals("-9,223,372,036,854,775,808", str);
    }

    @Test
    public void testOutOfBoundsValueConversion() {
        // Long.MAX_VALUE+1 is converted to Long.MAX_VALUE
        long l = converter.convertToModel("9223372036854775808", Long.class,
                null);
        Assert.assertEquals(Long.MAX_VALUE, l);
        // Long.MIN_VALUE-1 is converted to Long.MIN_VALUE
        l = converter.convertToModel("-9223372036854775809", Long.class, null);
        Assert.assertEquals(Long.MIN_VALUE, l);

    }
}
