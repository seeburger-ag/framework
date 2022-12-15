/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.converter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * A converter that converts from {@link String} to {@link BigDecimal} and back.
 * Uses the given locale and a {@link NumberFormat} instance for formatting and
 * parsing.
 * <p>
 * Leading and trailing white spaces are ignored when converting from a String.
 * </p>
 * <p>
 * Override and overwrite {@link #getFormat(Locale)} to use a different format.
 * </p>
 *
 * @author Vaadin Ltd
 * @since 7.2
 */
public class StringToBigDecimalConverter
        extends AbstractStringToNumberConverter<BigDecimal> {
    @Override
    protected NumberFormat getFormat(Locale locale) {
        NumberFormat numberFormat = super.getFormat(locale);
        if (numberFormat instanceof DecimalFormat) {
            ((DecimalFormat) numberFormat).setParseBigDecimal(true);
        }

        return numberFormat;
    }

    @Override
    public BigDecimal convertToModel(String value,
            Class<? extends BigDecimal> targetType, Locale locale)
            throws ConversionException {
        return (BigDecimal) convertToNumber(value, BigDecimal.class, locale);
    }

    @Override
    public Class<BigDecimal> getModelType() {
        return BigDecimal.class;
    }
}
