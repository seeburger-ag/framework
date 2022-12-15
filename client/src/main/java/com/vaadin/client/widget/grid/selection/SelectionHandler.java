/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.selection;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for {@link SelectionEvent}s.
 *
 * @author Vaadin Ltd
 * @param <T>
 *            The row data type
 * @since 7.4
 */
public interface SelectionHandler<T> extends EventHandler {

    /**
     * Called when a selection model's selection state is changed.
     *
     * @param event
     *            a selection event, containing info about rows that have been
     *            added to or removed from the selection.
     */
    public void onSelect(SelectionEvent<T> event);

}
