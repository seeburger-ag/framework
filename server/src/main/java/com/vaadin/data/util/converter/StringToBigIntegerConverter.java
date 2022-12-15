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
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * A converter that converts from {@link String} to {@link BigInteger} and back.
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
 * @since 7.4
 */
public class StringToBigIntegerConverter
        extends AbstractStringToNumberConverter<BigInteger> {

    @Override
    protected NumberFormat getFormat(Locale locale) {
        NumberFormat numberFormat = super.getFormat(locale);
        if (numberFormat instanceof DecimalFormat) {
            ((DecimalFormat) numberFormat).setParseBigDecimal(true);
        }

        return numberFormat;
    }

    @Override
    public BigInteger convertToModel(String value,
            Class<? extends BigInteger> targetType, Locale locale)
            throws ConversionException {

        BigDecimal bigDecimalValue = (BigDecimal) convertToNumber(value,
                BigDecimal.class, locale);

        return (bigDecimalValue != null) ? bigDecimalValue.toBigInteger()
                : null;
    }

    @Override
    public Class<BigInteger> getModelType() {
        return BigInteger.class;
    }
}
