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
 * Handler for a Grid select all event, called when the Grid needs all rows in
 * data source to be selected.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface SelectAllHandler<T> extends EventHandler {

    /**
     * Called when select all value in SelectionColumn header changes value.
     *
     * @param event
     *            select all event telling that all rows should be selected
     */
    public void onSelectAll(SelectAllEvent<T> event);

}
