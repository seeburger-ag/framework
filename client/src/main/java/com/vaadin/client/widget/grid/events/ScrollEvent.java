/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * An event that signifies that a scrollbar bundle has been scrolled
 *
 * @author Vaadin Ltd
 * @since 7.4
 */
public class ScrollEvent extends GwtEvent<ScrollHandler> {

    /** The type of this event */
    public static final Type<ScrollHandler> TYPE = new Type<ScrollHandler>();

    @Override
    public Type<ScrollHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ScrollHandler handler) {
        handler.onScroll(this);
    }
}
