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
 * Handler for a Grid enabled/disabled event, called when the Grid is enabled or
 * disabled.
 *
 * @since 7.7
 * @author Vaadin Ltd
 */
public interface GridEnabledHandler extends EventHandler {

    /**
     * Called when Grid is enabled or disabled.
     *
     * @param enabled
     *            true if status changes from disabled to enabled, otherwise
     *            false.
     */
    public void onEnabled(boolean enabled);
}
