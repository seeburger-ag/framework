/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.sort;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.vaadin.client.widgets.Grid;

/**
 * A sort event, fired by the Grid when it needs its data source to provide data
 * sorted in a specific manner.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class SortEvent<T> extends GwtEvent<SortHandler<?>> {

    private static final Type<SortHandler<?>> TYPE = new Type<SortHandler<?>>();

    private final Grid<T> grid;
    private final List<SortOrder> order;
    private final boolean userOriginated;

    /**
     * Creates a new Sort Event. All provided parameters are final, and passed
     * on as-is.
     *
     * @param grid
     *            a grid reference
     * @param order
     *            an array dictating the desired sort order of the data source
     * @param originator
     *            a value indicating where this event originated from
     */
    public SortEvent(Grid<T> grid, List<SortOrder> order,
            boolean userOriginated) {
        this.grid = grid;
        this.order = order;
        this.userOriginated = userOriginated;
    }

    @Override
    public Type<SortHandler<?>> getAssociatedType() {
        return TYPE;
    }

    /**
     * Static access to the GWT event type identifier associated with this Event
     * class
     *
     * @return a type object, uniquely describing this event type.
     */
    public static Type<SortHandler<?>> getType() {
        return TYPE;
    }

    /**
     * Get access to the Grid that fired this event
     *
     * @return the grid instance
     */
    @Override
    public Grid<T> getSource() {
        return grid;
    }

    /**
     * Get access to the Grid that fired this event
     *
     * @return the grid instance
     */
    public Grid<T> getGrid() {
        return grid;
    }

    /**
     * Get the sort ordering that is to be applied to the Grid
     *
     * @return a list of sort order objects
     */
    public List<SortOrder> getOrder() {
        return order;
    }

    /**
     * Returns whether this event originated from actions done by the user.
     *
     * @return true if sort event originated from user interaction
     */
    public boolean isUserOriginated() {
        return userOriginated;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void dispatch(SortHandler<?> handler) {
        ((SortHandler<T>) handler).sort(this);
    }

}
