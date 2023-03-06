/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.events;

import com.google.gwt.event.shared.GwtEvent;
import com.vaadin.client.widgets.Grid.Column;

/**
 * An event for notifying that the columns in the Grid have been resized.
 *
 * @param <T>
 *            The row type of the grid. The row type is the POJO type from where
 *            the data is retrieved into the column cells.
 * @since 7.6
 * @author Vaadin Ltd
 */
public class ColumnResizeEvent<T> extends GwtEvent<ColumnResizeHandler<T>> {

    /**
     * Handler type.
     */
    private final static Type<ColumnResizeHandler<?>> TYPE = new Type<ColumnResizeHandler<?>>();

    private Column<?, T> column;

    /**
     * @param column
     */
    public ColumnResizeEvent(Column<?, T> column) {
        this.column = column;
    }

    public static final Type<ColumnResizeHandler<?>> getType() {
        return TYPE;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Type<ColumnResizeHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(ColumnResizeHandler<T> handler) {
        handler.onColumnResize(this);
    }

    /**
     * @return the column
     */
    public Column<?, T> getColumn() {
        return column;
    }
}
