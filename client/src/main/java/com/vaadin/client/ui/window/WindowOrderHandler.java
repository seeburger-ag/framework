/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.window;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler for {@link WindowOrderEvent}s.
 *
 * @since 7.7.12
 *
 * @author Vaadin Ltd
 */
public interface WindowOrderHandler extends EventHandler {

    /**
     * Called when the VWindow instances changed their order position.
     *
     * @param event
     *            Contains windows whose position has changed
     */
    public void onWindowOrderChange(WindowOrderEvent event);
}