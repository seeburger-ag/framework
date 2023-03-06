/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for {@link DataAvailableEvent}s.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface DataAvailableHandler extends EventHandler {

    /**
     * Called when DataSource has data available. Supplied with row range.
     *
     * @param availableRows
     *            Range of rows available in the DataSource
     * @return true if the command was successfully completed, false to call
     *         again the next time new data is available
     */
    public void onDataAvailable(DataAvailableEvent event);
}
