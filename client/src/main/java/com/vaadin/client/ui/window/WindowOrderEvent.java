/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.window;

import java.util.ArrayList;

import com.google.gwt.event.shared.GwtEvent;
import com.vaadin.client.ui.VWindow;

/**
 * Event for window order position updates.
 *
 * @since 7.7.12
 *
 * @author Vaadin Ltd
 */
public class WindowOrderEvent extends GwtEvent<WindowOrderHandler> {

    private static final Type<WindowOrderHandler> TYPE = new Type<WindowOrderHandler>();

    private final ArrayList<VWindow> windows;

    /**
     * Creates a new event with the given order.
     *
     * @param windows
     *            The new order position for the VWindow
     */
    public WindowOrderEvent(ArrayList<VWindow> windows) {
        this.windows = windows;
    }

    @Override
    public Type<WindowOrderHandler> getAssociatedType() {
        return TYPE;
    }

    /**
     * Returns windows in order.
     *
     * @return windows in the specific order
     */
    public VWindow[] getWindows() {
        return windows.toArray(new VWindow[windows.size()]);
    }

    @Override
    protected void dispatch(WindowOrderHandler handler) {
        handler.onWindowOrderChange(this);
    }

    /**
     * Gets the type of the event.
     *
     * @return the type of the event
     */
    public static Type<WindowOrderHandler> getType() {
        return TYPE;
    }

}
