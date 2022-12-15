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
 * Handler for {@link WindowMoveEvent}s
 *
 * @since 7.1.9
 * @author Vaadin Ltd
 */
public interface WindowMoveHandler extends EventHandler {

    /**
     * Called when the VWindow was moved by the user.
     *
     * @param event
     *            Contains new coordinates for the VWindow
     */
    public void onWindowMove(WindowMoveEvent event);
}
