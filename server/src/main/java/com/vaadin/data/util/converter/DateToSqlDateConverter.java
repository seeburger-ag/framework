/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.data.util.converter;

import java.util.Date;
import java.util.Locale;

/**
 * Converter for handling conversion between {@link java.util.Date} and
 * {@link java.sql.Date}. This is used when a PopupDateField or InlineDateField
 * is connected to a java.sql.Date property, typically through a JPAContainer or
 * SQLContainer. Note that information (time information) is lost when
 * converting from {@link java.util.Date} to {@link java.sql.Date}.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public class DateToSqlDateConverter implements Converter<Date, java.sql.Date> {

    @Override
    public java.sql.Date convertToModel(Date value,
            Class<? extends java.sql.Date> targetType, Locale locale)
            throws ConversionException {
        if (targetType != getModelType()) {
            throw new ConversionException(
                    "Converter only supports " + getModelType().getName()
                            + " (targetType was " + targetType.getName() + ")");
        }

        if (value == null) {
            return null;
        }

        return new java.sql.Date(value.getTime());
    }

    @Override
    public Date convertToPresentation(java.sql.Date value,
            Class<? extends Date> targetType, Locale locale)
            throws ConversionException {
        if (targetType != getPresentationType()) {
            throw new ConversionException(
                    "Converter only supports " + getPresentationType().getName()
                            + " (targetType was " + targetType.getName() + ")");
        }

        if (value == null) {
            return null;
        }

        return new Date(value.getTime());
    }

    @Override
    public Class<java.sql.Date> getModelType() {
        return java.sql.Date.class;
    }

    @Override
    public Class<Date> getPresentationType() {
        return Date.class;
    }

}
