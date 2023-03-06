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
 * Event handler for a spacer visibility changed event.
 *
 * @author Vaadin Ltd
 * @since 7.7.13
 */
public interface SpacerVisibilityChangedHandler extends EventHandler {

    /**
     * Called when a spacer visibility changed event is fired, when a spacer's
     * visibility changes.
     *
     * @param event
     *            the spacer visibility changed event
     */
    public void onSpacerVisibilityChanged(SpacerVisibilityChangedEvent event);
}