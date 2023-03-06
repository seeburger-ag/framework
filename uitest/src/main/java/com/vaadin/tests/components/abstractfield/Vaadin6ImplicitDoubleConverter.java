/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.abstractfield;

import java.util.Locale;

import com.vaadin.data.util.converter.Converter;

public class Vaadin6ImplicitDoubleConverter
        implements Converter<String, Double> {

    @Override
    public Double convertToModel(String value,
            Class<? extends Double> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        if (null == value) {
            return null;
        }
        return new Double(value.toString());
    }

    @Override
    public String convertToPresentation(Double value,
            Class<? extends String> targetType, Locale locale)
            throws com.vaadin.data.util.converter.Converter.ConversionException {
        if (value == null) {
            return null;
        }
        return value.toString();

    }

    @Override
    public Class<Double> getModelType() {
        return Double.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }

}
