/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.escalator.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event fired when a spacer element is hidden or shown in Escalator.
 *
 * @author Vaadin Ltd
 * @since 7.7.13
 */
public class SpacerVisibilityChangedEvent
        extends GwtEvent<SpacerVisibilityChangedHandler> {

    /**
     * Handler type.
     */
    public static final Type<SpacerVisibilityChangedHandler> TYPE = new Type<SpacerVisibilityChangedHandler>();

    public static final Type<SpacerVisibilityChangedHandler> getType() {
        return TYPE;
    }

    private final int rowIndex;
    private final boolean visible;

    /**
     * Creates a spacer visibility changed event.
     *
     * @param rowIndex
     *            index of row to which the spacer belongs
     * @param visible
     *            {@code true} if the spacer element is shown, {@code false} if
     *            the spacer element is hidden
     */
    public SpacerVisibilityChangedEvent(int rowIndex, boolean visible) {
        this.rowIndex = rowIndex;
        this.visible = visible;
    }

    /**
     * Gets the row index to which the spacer element belongs.
     *
     * @return the row index to which the spacer element belongs
     */
    public int getRowIndex() {
        return rowIndex;
    }

    /**
     * Gets whether the spacer element is displayed.
     *
     * @return {@code true} if the spacer element is shown, {@code false} if the
     *         spacer element is hidden
     */
    public boolean isVisible() {
        return visible;
    }

    @Override
    public Type<SpacerVisibilityChangedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SpacerVisibilityChangedHandler handler) {
        handler.onSpacerVisibilityChanged(this);
    }

}