/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.google.gwt.dom.client.NativeEvent;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.shared.EventId;
import com.vaadin.shared.MouseEventDetails;

public abstract class ClickEventHandler extends AbstractClickEventHandler {

    public ClickEventHandler(ComponentConnector connector) {
        this(connector, EventId.CLICK_EVENT_IDENTIFIER);
    }

    public ClickEventHandler(ComponentConnector connector,
            String clickEventIdentifier) {
        super(connector, clickEventIdentifier);
    }

    /**
     * Sends the click event based on the given native event. Delegates actual
     * sending to {@link #fireClick(MouseEventDetails)}.
     *
     * @param event
     *            The native event that caused this click event
     */
    @Override
    protected void fireClick(NativeEvent event) {
        MouseEventDetails mouseDetails = MouseEventDetailsBuilder
                .buildMouseEventDetails(event, getRelativeToElement());
        fireClick(event, mouseDetails);
    }

    /**
     * Sends the click event to the server. Must be implemented by sub classes,
     * typically by calling an RPC method.
     *
     * @param event
     *            The event that caused this click to be fired
     *
     * @param mouseDetails
     *            The mouse details for the event
     */
    protected abstract void fireClick(NativeEvent event,
            MouseEventDetails mouseDetails);

}
