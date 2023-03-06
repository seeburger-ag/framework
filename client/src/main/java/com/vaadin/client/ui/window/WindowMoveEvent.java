/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.window;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event for window position updates
 *
 * @since 7.1.9
 * @author Vaadin Ltd
 */
public class WindowMoveEvent extends GwtEvent<WindowMoveHandler> {

    private static final Type<WindowMoveHandler> TYPE = new Type<WindowMoveHandler>();

    private final int newX;
    private final int newY;

    /**
     * Creates a new event with the given parameters
     *
     * @param x
     *            The new x-position for the VWindow
     * @param y
     *            The new y-position for the VWindow
     */
    public WindowMoveEvent(int x, int y) {
        newX = x;
        newY = y;
    }

    /**
     * Gets the new x position of the window
     *
     * @return the new X position of the VWindow
     */
    public int getNewX() {
        return newX;
    }

    /**
     * Gets the new y position of the window
     *
     * @return the new Y position of the VWindow
     */
    public int getNewY() {
        return newY;
    }

    /**
     * Gets the type of the event
     *
     * @return the type of the event
     */
    public static Type<WindowMoveHandler> getType() {
        return TYPE;
    }

    @Override
    public Type<WindowMoveHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(WindowMoveHandler handler) {
        handler.onWindowMove(this);
    }
}
