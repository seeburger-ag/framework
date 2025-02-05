/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.converter;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.data.util.converter.DateToLongConverter;

public class DateToLongConverterTest {

    DateToLongConverter converter = new DateToLongConverter();

    @Test
    public void testNullConversion() {
        Assert.assertEquals(null,
                converter.convertToModel(null, Long.class, null));
    }

    @Test
    public void testValueConversion() {
        Date d = new Date(100, 0, 1);
        Assert.assertEquals(
                Long.valueOf(946677600000l
                        + (d.getTimezoneOffset() + 120) * 60 * 1000L),
                converter.convertToModel(d, Long.class, null));
    }
}
