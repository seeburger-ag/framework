/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.event;

import com.google.gwt.event.dom.client.DomEvent;

/**
 * Represents a native PointerDownEvent.
 *
 * @since 7.2
 */
public class PointerDownEvent extends PointerEvent<PointerDownHandler> {

    /**
     * Event type for PointerDownEvent. Represents the meta-data associated with
     * this event.
     */
    private static final Type<PointerDownHandler> TYPE = new Type<PointerDownHandler>(
            EventType.PointerDown.getNativeEventName(), new PointerDownEvent());

    /**
     * Gets the event type associated with PointerDownEvent events.
     *
     * @return the handler type
     */
    public static Type<PointerDownHandler> getType() {
        return TYPE;
    }

    /**
     * Protected constructor, use
     * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
     * to fire pointer down events.
     */
    protected PointerDownEvent() {
    }

    @Override
    public final Type<PointerDownHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PointerDownHandler handler) {
        handler.onPointerDown(this);
    }

}
