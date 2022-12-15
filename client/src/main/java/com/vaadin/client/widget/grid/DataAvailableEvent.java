/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid;

import com.google.gwt.event.shared.GwtEvent;
import com.vaadin.shared.ui.grid.Range;

/**
 * Event object describing a change of row availability in DataSource of a Grid.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class DataAvailableEvent extends GwtEvent<DataAvailableHandler> {

    private Range rowsAvailable;
    public static final Type<DataAvailableHandler> TYPE = new Type<DataAvailableHandler>();

    public DataAvailableEvent(Range rowsAvailable) {
        this.rowsAvailable = rowsAvailable;
    }

    /**
     * Returns the range of available rows in {@link DataSource} for this event.
     *
     * @return range of available rows
     */
    public Range getAvailableRows() {
        return rowsAvailable;
    }

    @Override
    public Type<DataAvailableHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DataAvailableHandler handler) {
        handler.onDataAvailable(this);
    }

}
