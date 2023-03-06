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
 * An enabled/disabled event, fired by the Grid when it is disabled or enabled.
 *
 * @since 7.7
 * @author Vaadin Ltd
 */
public class GridEnabledEvent extends GwtEvent<GridEnabledHandler> {
    /**
     * The type of this event
     */
    public static final Type<GridEnabledHandler> TYPE = new Type<GridEnabledHandler>();
    private final boolean enabled;

    public GridEnabledEvent(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Type<GridEnabledHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final GridEnabledHandler handler) {
        handler.onEnabled(enabled);
    }
}
