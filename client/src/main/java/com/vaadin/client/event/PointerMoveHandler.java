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
 * Handler interface for {@link PointerMoveEvent} events.
 *
 * @since 7.2
 */
public interface PointerMoveHandler extends EventHandler {

    /**
     * Called when PointerMoveEvent is fired.
     *
     * @param event
     *            the {@link PointerMoveEvent} that was fired
     */
    void onPointerMove(PointerMoveEvent event);
}
