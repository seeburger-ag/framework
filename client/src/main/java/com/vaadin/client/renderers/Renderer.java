/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.renderers;

import com.vaadin.client.widget.escalator.Cell;
import com.vaadin.client.widget.grid.RendererCellReference;
import com.vaadin.client.widgets.Grid;

/**
 * Renderer for rending a value &lt;T&gt; into cell.
 * <p>
 * You can add a renderer to any column by overring the
 * {@link GridColumn#getRenderer()} method and returning your own renderer. You
 * can retrieve the cell element using {@link Cell#getElement()}.
 *
 * @param <T>
 *            The column type
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface Renderer<T> {

    /**
     * Called whenever the {@link Grid} updates a cell.
     * <p>
     * For optimal performance, work done in this method should be kept to a
     * minimum since it will be called continuously while the user is scrolling.
     * It is recommended to set up the cell's DOM structure in
     * {@link ComplexRenderer#init(RendererCellReference)} and only make
     * incremental updates based on cell data in this method.
     *
     * @param cell
     *            The cell. Note that the cell is a flyweight and should not be
     *            stored outside of the method as it will change.
     *
     * @param data
     *            The column data object
     */
    void render(RendererCellReference cell, T data);
}
