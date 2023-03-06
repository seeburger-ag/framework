/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.declarative.converters;

import java.util.Locale;
import java.util.TimeZone;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.declarative.DesignAttributeHandler;

/**
 * Utility class for {@link DesignAttributeHandler} that deals with converting
 * various TimeZones to string.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class DesignTimeZoneConverter implements Converter<String, TimeZone> {

    @Override
    public TimeZone convertToModel(String value,
            Class<? extends TimeZone> targetTimeZone, Locale locale)
            throws Converter.ConversionException {
        if (value == null || value.isEmpty()) {
            return null;
        }

        return TimeZone.getTimeZone(value);
    }

    @Override
    public String convertToPresentation(TimeZone value,
            Class<? extends String> targetTimeZone, Locale locale)
            throws Converter.ConversionException {
        if (value == null) {
            return "";
        } else {
            return value.getID();
        }
    }

    @Override
    public Class<TimeZone> getModelType() {
        return TimeZone.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }

}
