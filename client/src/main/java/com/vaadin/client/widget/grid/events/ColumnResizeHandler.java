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
 * Handler for a Grid column resize event, called when the Grid's columns has
 * been resized.
 *
 * @param <T>
 *            The row type of the grid. The row type is the POJO type from where
 *            the data is retrieved into the column cells.
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface ColumnResizeHandler<T> extends EventHandler {

    /**
     * A column resize event, fired by Grid when the columns of the Grid have
     * been resized.
     *
     * @param event
     *            column resize event
     */
    public void onColumnResize(ColumnResizeEvent<T> event);
}
