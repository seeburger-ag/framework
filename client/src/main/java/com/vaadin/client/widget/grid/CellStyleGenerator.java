/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid;

import com.vaadin.client.widgets.Grid;

/**
 * Callback interface for generating custom style names for cells
 *
 * @author Vaadin Ltd
 * @param <T>
 *            the row type of the target grid
 * @see Grid#setCellStyleGenerator(CellStyleGenerator)
 * @since 7.4
 */
public interface CellStyleGenerator<T> {

    /**
     * Called by Grid to generate a style name for a column element.
     *
     * @param cellReference
     *            The cell to generate a style for
     * @return the style name to add to this cell, or {@code null} to not set
     *         any style
     */
    public abstract String getStyle(CellReference<T> cellReference);
}