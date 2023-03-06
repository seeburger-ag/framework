/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.data.util.converter;

import java.io.Serializable;

/**
 * Factory interface for providing Converters based on a presentation type and a
 * model type.
 *
 * @author Vaadin Ltd.
 * @since 7.0
 *
 */
public interface ConverterFactory extends Serializable {
    public <PRESENTATION, MODEL> Converter<PRESENTATION, MODEL> createConverter(
            Class<PRESENTATION> presentationType, Class<MODEL> modelType);

}
