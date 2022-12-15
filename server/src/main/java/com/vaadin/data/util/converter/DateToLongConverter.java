/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.data.util.converter;

import java.util.Date;
import java.util.Locale;

/**
 * A converter that converts from {@link Long} to {@link Date} and back.
 *
 * @author Vaadin Ltd
 * @since 7.0
 */
public class DateToLongConverter implements Converter<Date, Long> {

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.data.util.converter.Converter#convertToModel(java.lang.Object,
     * java.lang.Class, java.util.Locale)
     */
    @Override
    public Long convertToModel(Date value, Class<? extends Long> targetType,
            Locale locale) {
        if (value == null) {
            return null;
        }

        return value.getTime();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.data.util.converter.Converter#convertToPresentation(java.lang
     * .Object, java.lang.Class, java.util.Locale)
     */
    @Override
    public Date convertToPresentation(Long value,
            Class<? extends Date> targetType, Locale locale) {
        if (targetType != getPresentationType()) {
            throw new ConversionException(
                    "Converter only supports " + getPresentationType().getName()
                            + " (targetType was " + targetType.getName() + ")");
        }
        if (value == null) {
            return null;
        }

        return new Date(value);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.data.util.converter.Converter#getModelType()
     */
    @Override
    public Class<Long> getModelType() {
        return Long.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.data.util.converter.Converter#getPresentationType()
     */
    @Override
    public Class<Date> getPresentationType() {
        return Date.class;
    }

}
