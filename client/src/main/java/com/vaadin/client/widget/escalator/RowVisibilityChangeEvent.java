/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.widget.escalator;

import com.google.gwt.event.shared.GwtEvent;
import com.vaadin.shared.ui.grid.Range;

/**
 * Event fired when the range of visible rows changes e.g. because of scrolling.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class RowVisibilityChangeEvent
        extends GwtEvent<RowVisibilityChangeHandler> {
    /**
     * The type of this event.
     */
    public static final Type<RowVisibilityChangeHandler> TYPE = new Type<RowVisibilityChangeHandler>();

    private final Range visibleRows;

    /**
     * Creates a new row visibility change event
     *
     * @param firstVisibleRow
     *            the index of the first visible row
     * @param visibleRowCount
     *            the number of visible rows
     */
    public RowVisibilityChangeEvent(int firstVisibleRow, int visibleRowCount) {
        visibleRows = Range.withLength(firstVisibleRow, visibleRowCount);
    }

    /**
     * Gets the index of the first row that is at least partially visible.
     *
     * @return the index of the first visible row
     */
    public int getFirstVisibleRow() {
        return visibleRows.getStart();
    }

    /**
     * Gets the number of at least partially visible rows.
     *
     * @return the number of visible rows
     */
    public int getVisibleRowCount() {
        return visibleRows.length();
    }

    /**
     * Gets the range of visible rows.
     *
     * @since 7.6
     * @return the visible rows
     */
    public Range getVisibleRowRange() {
        return visibleRows;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
     */
    @Override
    public Type<RowVisibilityChangeHandler> getAssociatedType() {
        return TYPE;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared
     * .EventHandler)
     */
    @Override
    protected void dispatch(RowVisibilityChangeHandler handler) {
        handler.onRowVisibilityChange(this);
    }

}
