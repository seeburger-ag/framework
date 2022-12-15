/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid;

import java.io.Serializable;

/**
 * Callback interface for generating custom style names for data rows
 *
 * @author Vaadin Ltd
 * @param <T>
 *            the row type of the target grid
 * @see Grid#setRowStyleGenerator(RowStyleGenerator)
 * @since 7.4
 */
public interface RowStyleGenerator<T> extends Serializable {

    /**
     * Called by Grid to generate a style name for a row.
     *
     * @param rowReference
     *            The row to generate a style for
     * @return the style name to add to this row, or {@code null} to not set any
     *         style
     */
    public abstract String getStyle(RowReference<T> rowReference);
}