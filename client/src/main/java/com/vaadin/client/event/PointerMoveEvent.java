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
 * Represents a native PointerMoveEvent event.
 *
 * @since 7.2
 */
public class PointerMoveEvent extends PointerEvent<PointerMoveHandler> {

    /**
     * Event type for PointerMoveEvent. Represents the meta-data associated with
     * this event.
     */
    private static final Type<PointerMoveHandler> TYPE = new Type<PointerMoveHandler>(
            EventType.PointerMove.getNativeEventName(), new PointerMoveEvent());

    /**
     * Gets the event type associated with PointerMoveEvent.
     *
     * @return the handler type
     */
    public static Type<PointerMoveHandler> getType() {
        return TYPE;
    }

    /**
     * Protected constructor, use
     * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
     * to fire pointer down events.
     */
    protected PointerMoveEvent() {
    }

    @Override
    public final Type<PointerMoveHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PointerMoveHandler handler) {
        handler.onPointerMove(this);
    }

}
