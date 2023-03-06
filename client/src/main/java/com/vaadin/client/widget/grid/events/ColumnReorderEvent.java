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

/**
 * An event for notifying that the columns in the Grid have been reordered.
 *
 * @param <T>
 *            The row type of the grid. The row type is the POJO type from where
 *            the data is retrieved into the column cells.
 * @since 7.5.0
 * @author Vaadin Ltd
 */
public class ColumnReorderEvent<T> extends GwtEvent<ColumnReorderHandler<T>> {

    /**
     * Handler type.
     */
    private final static Type<ColumnReorderHandler<?>> TYPE = new Type<ColumnReorderHandler<?>>();

    public static final Type<ColumnReorderHandler<?>> getType() {
        return TYPE;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Type<ColumnReorderHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(ColumnReorderHandler<T> handler) {
        handler.onColumnReorder(this);
    }

}
