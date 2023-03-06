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

import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.declarative.DesignAttributeHandler;

/**
 * An converter for Enum to/from String for {@link DesignAttributeHandler} to
 * use internally.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class DesignEnumConverter implements Converter<String, Enum> {

    @Override
    public Enum convertToModel(String value, Class<? extends Enum> targetType,
            Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        if (value == null || value.trim().equals("")) {
            return null;
        }
        return Enum.valueOf(targetType, value.toUpperCase(Locale.ENGLISH));
    }

    @Override
    public String convertToPresentation(Enum value,
            Class<? extends String> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        if (value == null) {
            return null;
        }

        return value.name().toLowerCase(Locale.ENGLISH);
    }

    @Override
    public Class<Enum> getModelType() {
        return Enum.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }

}
