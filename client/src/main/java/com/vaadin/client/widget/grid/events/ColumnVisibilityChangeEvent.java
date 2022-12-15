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
 * An event for notifying that the columns in the Grid's have changed
 * visibility.
 *
 * @param <T>
 *            The row type of the grid. The row type is the POJO type from where
 *            the data is retrieved into the column cells.
 * @since 7.5.0
 * @author Vaadin Ltd
 */
public class ColumnVisibilityChangeEvent<T>
        extends GwtEvent<ColumnVisibilityChangeHandler<T>> {

    private final static Type<ColumnVisibilityChangeHandler<?>> TYPE = new Type<ColumnVisibilityChangeHandler<?>>();

    public static final Type<ColumnVisibilityChangeHandler<?>> getType() {
        return TYPE;
    }

    private final Column<?, T> column;

    private final boolean userOriginated;

    private final boolean hidden;

    public ColumnVisibilityChangeEvent(Column<?, T> column, boolean hidden,
            boolean userOriginated) {
        this.column = column;
        this.hidden = hidden;
        this.userOriginated = userOriginated;
    }

    /**
     * Returns the column where the visibility change occurred.
     *
     * @return the column where the visibility change occurred.
     */
    public Column<?, T> getColumn() {
        return column;
    }

    /**
     * Was the column set hidden or visible.
     *
     * @return <code>true</code> if the column was hidden <code>false</code> if
     *         it was set visible
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Is the visibility change triggered by user.
     *
     * @return <code>true</code> if the change was triggered by user,
     *         <code>false</code> if not
     */
    public boolean isUserOriginated() {
        return userOriginated;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<ColumnVisibilityChangeHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(ColumnVisibilityChangeHandler<T> handler) {
        handler.onVisibilityChange(this);
    }

}
