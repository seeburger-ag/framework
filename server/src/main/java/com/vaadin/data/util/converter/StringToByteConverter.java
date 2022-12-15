/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.data.util.converter;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A converter that converts from {@link String} to {@link Byte} and back. Uses
 * the given locale and a {@link NumberFormat} instance for formatting and
 * parsing.
 * <p>
 * Override and overwrite {@link #getFormat(Locale)} to use a different format.
 * </p>
 *
 * @author Vaadin Ltd
 * @since 7.4
 */
public class StringToByteConverter
        extends AbstractStringToNumberConverter<Byte> {

    /**
     * Returns the format used by
     * {@link #convertToPresentation(Byte, Class, Locale)} and
     * {@link #convertToModel(String, Class, Locale)}
     *
     * @param locale
     *            The locale to use
     * @return A NumberFormat instance
     */
    @Override
    protected NumberFormat getFormat(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return NumberFormat.getIntegerInstance(locale);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.data.util.converter.Converter#convertToModel(java.lang.Object,
     * java.lang.Class, java.util.Locale)
     */
    @Override
    public Byte convertToModel(String value, Class<? extends Byte> targetType,
            Locale locale) throws ConversionException {
        Number n = convertToNumber(value, targetType, locale);

        if (n == null) {
            return null;
        }

        byte byteValue = n.byteValue();
        if (byteValue == n.longValue()) {
            return byteValue;
        }

        throw new ConversionException("Could not convert '" + value + "' to "
                + Byte.class.getName() + ": value out of range");

    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.data.util.converter.Converter#getModelType()
     */
    @Override
    public Class<Byte> getModelType() {
        return Byte.class;
    }

}
