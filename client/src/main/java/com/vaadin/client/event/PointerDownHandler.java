/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for {@link PointerDownEvent} events.
 *
 * @since 7.2
 */
public interface PointerDownHandler extends EventHandler {

    /**
     * Called when PointerDownEvent is fired.
     *
     * @param event
     *            the {@link PointerDownEvent} that was fired
     */
    void onPointerDown(PointerDownEvent event);
}
