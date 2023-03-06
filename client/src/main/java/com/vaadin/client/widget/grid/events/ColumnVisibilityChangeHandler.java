/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for a Grid column visibility change event, called when the Grid's
 * columns have changed visibility to hidden or visible.
 *
 * @param<T> The
 *               row type of the grid. The row type is the POJO type from where
 *               the data is retrieved into the column cells.
 *
 * @since 7.5.0
 * @author Vaadin Ltd
 */
public interface ColumnVisibilityChangeHandler<T> extends EventHandler {

    /**
     * A column visibility change event, fired by Grid when a column in the Grid
     * has changed visibility.
     *
     * @param event
     *            column visibility change event
     */
    public void onVisibilityChange(ColumnVisibilityChangeEvent<T> event);
}
