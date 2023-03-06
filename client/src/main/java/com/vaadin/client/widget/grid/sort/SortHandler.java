/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.sort;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for a Grid sort event, called when the Grid needs its data source to
 * provide data sorted in a specific manner.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface SortHandler<T> extends EventHandler {

    /**
     * Handle sorting of the Grid. This method is called when a re-sorting of
     * the Grid's data is requested.
     *
     * @param event
     *            the sort event
     */
    public void sort(SortEvent<T> event);

}
