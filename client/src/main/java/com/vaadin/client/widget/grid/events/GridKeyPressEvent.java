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
import com.vaadin.client.widget.grid.CellReference;
import com.vaadin.client.widget.grid.events.AbstractGridKeyEventHandler.GridKeyPressHandler;
import com.vaadin.client.widgets.Grid;
import com.vaadin.client.widgets.Grid.AbstractGridKeyEvent;
import com.vaadin.shared.ui.grid.GridConstants.Section;

/**
 * Represents native key press event in Grid.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class GridKeyPressEvent
        extends AbstractGridKeyEvent<GridKeyPressHandler> {

    /**
     * @since 7.7.9
     */
    public static final Type<GridKeyPressHandler> TYPE = new Type<GridKeyPressHandler>(
            BrowserEvents.KEYPRESS, new GridKeyPressEvent());

    /**
     * @since 7.7.9
     */
    public GridKeyPressEvent() {
    }

    /**
     * @deprecated This constructor's arguments are no longer used. Use the
     *             no-args constructor instead.
     */
    @Deprecated
    public GridKeyPressEvent(Grid<?> grid, CellReference<?> targetCell) {
    }

    /**
     * @since 7.7.9
     */
    @Override
    public Type<GridKeyPressHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void doDispatch(GridKeyPressHandler handler, Section section) {
        if ((section == Section.BODY && handler instanceof BodyKeyPressHandler)
                || (section == Section.HEADER
                        && handler instanceof HeaderKeyPressHandler)
                || (section == Section.FOOTER
                        && handler instanceof FooterKeyPressHandler)) {
            handler.onKeyPress(this);
        }
    }

    @Override
    protected String getBrowserEventType() {
        return BrowserEvents.KEYPRESS;
    }

    /**
     * Gets the char code for this event.
     *
     * @return the char code
     */
    public char getCharCode() {
        return (char) getUnicodeCharCode();
    }

    /**
     * Gets the Unicode char code (code point) for this event.
     *
     * @return the Unicode char code
     */
    public int getUnicodeCharCode() {
        return getNativeEvent().getCharCode();
    }

    @Override
    public String toDebugString() {
        return super.toDebugString() + "[" + getCharCode() + "]";
    }
}