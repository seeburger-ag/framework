/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.events;

import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.event.dom.client.KeyCodes;
import com.vaadin.client.widget.grid.CellReference;
import com.vaadin.client.widget.grid.events.AbstractGridKeyEventHandler.GridKeyUpHandler;
import com.vaadin.client.widgets.Grid;
import com.vaadin.client.widgets.Grid.AbstractGridKeyEvent;
import com.vaadin.shared.ui.grid.GridConstants.Section;

/**
 * Represents native key up event in Grid.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class GridKeyUpEvent extends AbstractGridKeyEvent<GridKeyUpHandler> {

    /**
     * @since 7.7.9
     */
    public static final Type<GridKeyUpHandler> TYPE = new Type<GridKeyUpHandler>(
            BrowserEvents.KEYUP, new GridKeyUpEvent());

    /**
     * @since 7.7.9
     */
    public GridKeyUpEvent() {
    }

    /**
     * @deprecated This constructor's arguments are no longer used. Use the
     *             no-args constructor instead.
     */
    @Deprecated
    public GridKeyUpEvent(Grid<?> grid, CellReference<?> targetCell) {
    }

    @Override
    protected void doDispatch(GridKeyUpHandler handler, Section section) {
        if ((section == Section.BODY && handler instanceof BodyKeyUpHandler)
                || (section == Section.HEADER
                        && handler instanceof HeaderKeyUpHandler)
                || (section == Section.FOOTER
                        && handler instanceof FooterKeyUpHandler)) {
            handler.onKeyUp(this);
        }
    }

    /**
     * @since 7.7.9
     */
    @Override
    public Type<GridKeyUpHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected String getBrowserEventType() {
        return BrowserEvents.KEYUP;
    }

    /**
     * Does the key code represent an arrow key?
     *
     * @param keyCode
     *            the key code
     * @return if it is an arrow key code
     */
    public static boolean isArrow(int keyCode) {
        switch (keyCode) {
        case KeyCodes.KEY_DOWN:
        case KeyCodes.KEY_RIGHT:
        case KeyCodes.KEY_UP:
        case KeyCodes.KEY_LEFT:
            return true;
        default:
            return false;
        }
    }

    /**
     * Gets the native key code. These key codes are enumerated in the
     * {@link KeyCodes} class.
     *
     * @return the key code
     */
    public int getNativeKeyCode() {
        return getNativeEvent().getKeyCode();
    }

    /**
     * Is this a key down arrow?
     *
     * @return whether this is a down arrow key event
     */
    public boolean isDownArrow() {
        return getNativeKeyCode() == KeyCodes.KEY_DOWN;
    }

    /**
     * Is this a left arrow?
     *
     * @return whether this is a left arrow key event
     */
    public boolean isLeftArrow() {
        return getNativeKeyCode() == KeyCodes.KEY_LEFT;
    }

    /**
     * Is this a right arrow?
     *
     * @return whether this is a right arrow key event
     */
    public boolean isRightArrow() {
        return getNativeKeyCode() == KeyCodes.KEY_RIGHT;
    }

    /**
     * Is this a up arrow?
     *
     * @return whether this is a right arrow key event
     */
    public boolean isUpArrow() {
        return getNativeKeyCode() == KeyCodes.KEY_UP;
    }

    @Override
    public String toDebugString() {
        return super.toDebugString() + "[" + getNativeKeyCode() + "]";
    }
}
