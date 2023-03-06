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
 * An converter for Object to/from String for {@link DesignAttributeHandler} to
 * use internally.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class DesignObjectConverter implements Converter<String, Object> {

    @Override
    public Object convertToModel(String value,
            Class<? extends Object> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        return value;
    }

    @Override
    public String convertToPresentation(Object value,
            Class<? extends String> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        if (value == null) {
            return null;
        }

        return value.toString();
    }

    @Override
    public Class<Object> getModelType() {
        return Object.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }

}
