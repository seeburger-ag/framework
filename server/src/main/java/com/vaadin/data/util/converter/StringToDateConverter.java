/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.data.util.converter;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/**
 * A converter that converts from {@link Date} to {@link String} and back. Uses
 * the given locale and {@link DateFormat} for formatting and parsing.
 * <p>
 * Leading and trailing white spaces are ignored when converting from a String.
 * </p>
 * <p>
 * Override and overwrite {@link #getFormat(Locale)} to use a different format.
 * </p>
 *
 * @author Vaadin Ltd
 * @since 7.0
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * Returns the format used by
     * {@link #convertToPresentation(Date, Class,Locale)} and
     * {@link #convertToModel(String, Class, Locale)}.
     *
     * @param locale
     *            The locale to use
     * @return A DateFormat instance
     */
    protected DateFormat getFormat(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }

        DateFormat f = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
                DateFormat.MEDIUM, locale);
        f.setLenient(false);
        return f;
    }

    @Override
    public Date convertToModel(String value, Class<? extends Date> targetType,
            Locale locale) throws ConversionException {
        if (targetType != getModelType()) {
            throw new ConversionException(
                    "Converter only supports " + getModelType().getName()
                            + " (targetType was " + targetType.getName() + ")");
        }

        if (value == null) {
            return null;
        }

        // Remove leading and trailing white space
        value = value.trim();

        ParsePosition parsePosition = new ParsePosition(0);
        Date parsedValue = getFormat(locale).parse(value, parsePosition);
        if (parsePosition.getIndex() != value.length()) {
            throw new ConversionException("Could not convert '" + value
                    + "' to " + getModelType().getName());
        }

        return parsedValue;
    }

    @Override
    public String convertToPresentation(Date value,
            Class<? extends String> targetType, Locale locale)
            throws ConversionException {
        if (value == null) {
            return null;
        }

        return getFormat(locale).format(value);
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
