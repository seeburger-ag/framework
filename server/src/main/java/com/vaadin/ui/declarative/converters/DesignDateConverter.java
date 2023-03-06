/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.declarative.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.declarative.DesignAttributeHandler;

/**
 * A date converter to be used by {@link DesignAttributeHandler}. Provides
 * ISO-compliant way of storing date and time.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class DesignDateConverter implements Converter<String, Date> {

    @Override
    public Date convertToModel(String value, Class<? extends Date> targetType,
            Locale locale) throws Converter.ConversionException {
        for (String pattern : new String[] { "yyyy-MM-dd HH:mm:ssZ",
                "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH",
                "yyyy-MM-dd", "yyyy-MM", "yyyy" }) {
            try {
                return new SimpleDateFormat(pattern).parse(value);
            } catch (ParseException e) {
                // not parseable, ignore and try another format
            }
        }
        return null;
    }

    @Override
    public String convertToPresentation(Date value,
            Class<? extends String> targetType, Locale locale)
            throws Converter.ConversionException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ").format(value);
    }

    @Override
    public Class<Date> getModelType() {
        return Date.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }

}
