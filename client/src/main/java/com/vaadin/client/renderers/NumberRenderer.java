/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.renderers;

import com.google.gwt.i18n.client.NumberFormat;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * Renders a number into a cell using a specific {@link NumberFormat}. By
 * default uses the default number format returned by
 * {@link NumberFormat#getDecimalFormat()}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 * @param <T>
 *            The number type to render.
 */
public class NumberRenderer implements Renderer<Number> {

    private NumberFormat format;

    public NumberRenderer() {
        this(NumberFormat.getDecimalFormat());
    }

    public NumberRenderer(NumberFormat format) {
        setFormat(format);
    }

    /**
     * Gets the number format that the number should be formatted in.
     *
     * @return the number format used to render the number
     */
    public NumberFormat getFormat() {
        return format;
    }

    /**
     * Sets the number format to use for formatting the number.
     *
     * @param format
     *            the format to use
     * @throws IllegalArgumentException
     *             when the format is null
     */
    public void setFormat(NumberFormat format) throws IllegalArgumentException {
        if (format == null) {
            throw new IllegalArgumentException("Format cannot be null");
        }
        this.format = format;
    }

    @Override
    public void render(RendererCellReference cell, Number number) {
        cell.getElement().setInnerText(format.format(number));
    }
}
