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
 * Represents a native PointerCancelEvent.
 *
 * @since 7.2
 */
public class PointerCancelEvent extends PointerEvent<PointerCancelHandler> {

    /**
     * Event type for PointerCancelEvent. Represents the meta-data associated
     * with this event.
     */
    private static final Type<PointerCancelHandler> TYPE = new Type<PointerCancelHandler>(
            EventType.PointerCancel.getNativeEventName(),
            new PointerCancelEvent());

    /**
     * Gets the event type associated with pointer cancel events.
     *
     * @return the handler type
     */
    public static Type<PointerCancelHandler> getType() {
        return TYPE;
    }

    /**
     * Protected constructor, use
     * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
     * to fire pointer up events.
     */
    protected PointerCancelEvent() {
    }

    @Override
    public final Type<PointerCancelHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PointerCancelHandler handler) {
        handler.onPointerCancel(this);
    }

}
