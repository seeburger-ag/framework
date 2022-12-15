/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.event;

import com.vaadin.client.event.PointerEvent.EventType;

/**
 * Main pointer event support implementation class. Made for browser without
 * pointer event support.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class PointerEventSupportImpl {

    /**
     * @return true if the pointer events are supported, false otherwise
     */
    protected boolean isSupported() {
        return false;
    }

    /**
     * @param events
     * @return the native event name of the given event
     */
    public String getNativeEventName(EventType eventName) {
        return eventName.toString().toLowerCase();
    }

    /**
     * Initializes event support
     */
    protected void init() {

    }

}
