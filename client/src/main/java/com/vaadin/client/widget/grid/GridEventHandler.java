/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid;

import com.vaadin.client.widgets.Grid.GridEvent;

/**
 * A handler for events emitted by elements in Grid.
 *
 * @param <T>
 *            the grid row type
 */
public interface GridEventHandler<T> {
    /**
     * Attempts to handle the given grid event.
     *
     * @param event
     *            the event that occurred
     */
    public void onEvent(GridEvent<T> event);
}
