/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.escalator.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * Event handler for a row height changed event.
 *
 * @since 7.7
 * @author Vaadin Ltd
 */
public interface RowHeightChangedHandler extends EventHandler {

    /**
     * A row height changed event, fired by Escalator when the header, body or
     * footer row height has changed.
     *
     * @param event
     *            Row height changed event
     */
    public void onRowHeightChanged(RowHeightChangedEvent event);
}
