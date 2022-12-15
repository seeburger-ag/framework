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
 * Event fired when the row height changed in the Escalator's header, body or
 * footer.
 *
 * @since 7.7
 * @author Vaadin Ltd
 */
public class RowHeightChangedEvent extends GwtEvent<RowHeightChangedHandler> {

    /**
     * Handler type.
     */
    public final static Type<RowHeightChangedHandler> TYPE = new Type<RowHeightChangedHandler>();

    public static final Type<RowHeightChangedHandler> getType() {
        return TYPE;
    }

    @Override
    public Type<RowHeightChangedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RowHeightChangedHandler handler) {
        handler.onRowHeightChanged(this);
    }

}
