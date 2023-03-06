/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.data.util.converter;

import java.util.Locale;

/**
 * A converter that wraps another {@link Converter} and reverses source and
 * target types.
 *
 * @param <MODEL>
 *            The source type
 * @param <PRESENTATION>
 *            The target type
 *
 * @author Vaadin Ltd
 * @since 7.0
 */
public class ReverseConverter<PRESENTATION, MODEL>
        implements Converter<PRESENTATION, MODEL> {

    private Converter<MODEL, PRESENTATION> realConverter;

    /**
     * Creates a converter from source to target based on a converter that
     * converts from target to source.
     *
     * @param converter
     *            The converter to use in a reverse fashion
     */
    public ReverseConverter(Converter<MODEL, PRESENTATION> converter) {
        this.realConverter = converter;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.data.util.converter.Converter#convertToModel(java
     * .lang.Object, java.util.Locale)
     */
    @Override
    public MODEL convertToModel(PRESENTATION value,
            Class<? extends MODEL> targetType, Locale locale)
            throws ConversionException {
        return realConverter.convertToPresentation(value, targetType, locale);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.data.util.converter.Converter#convertToPresentation(java.lang
     * .Object, java.util.Locale)
     */
    @Override
    public PRESENTATION convertToPresentation(MODEL value,
            Class<? extends PRESENTATION> targetType, Locale locale)
            throws ConversionException {
        return realConverter.convertToModel(value, targetType, locale);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.data.util.converter.Converter#getSourceType()
     */
    @Override
    public Class<MODEL> getModelType() {
        return realConverter.getPresentationType();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.data.util.converter.Converter#getTargetType()
     */
    @Override
    public Class<PRESENTATION> getPresentationType() {
        return realConverter.getModelType();
    }

}
