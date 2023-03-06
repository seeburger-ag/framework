/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.selection;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Marker interface for widgets that fires selection events.
 *
 * @author Vaadin Ltd
 * @since 7.4
 */
public interface HasSelectionHandlers<T> {

    /**
     * Register a selection change handler.
     * <p>
     * This handler is called whenever a
     * {@link com.vaadin.ui.components.grid.selection.SelectionModel
     * SelectionModel} detects a change in selection state.
     *
     * @param handler
     *            a {@link SelectionHandler}
     * @return a handler registration object, which can be used to remove the
     *         handler.
     */
    public HandlerRegistration addSelectionHandler(SelectionHandler<T> handler);

}
