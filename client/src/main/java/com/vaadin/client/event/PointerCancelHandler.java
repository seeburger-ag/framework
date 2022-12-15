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
 * Handler interface for {@link PointerCancelEvent} events.
 *
 * @since 7.2
 */
public interface PointerCancelHandler extends EventHandler {

    /**
     * Called when PointerCancelEvent is fired.
     *
     * @param event
     *            the {@link PointerCancelEvent} that was fired
     */
    void onPointerCancel(PointerCancelEvent event);
}
