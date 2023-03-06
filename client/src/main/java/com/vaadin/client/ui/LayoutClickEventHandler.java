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
import com.vaadin.shared.ui.LayoutClickRpc;

public abstract class LayoutClickEventHandler
        extends AbstractClickEventHandler {

    public LayoutClickEventHandler(ComponentConnector connector) {
        this(connector, EventId.LAYOUT_CLICK_EVENT_IDENTIFIER);
    }

    public LayoutClickEventHandler(ComponentConnector connector,
            String clickEventIdentifier) {
        super(connector, clickEventIdentifier);
    }

    protected abstract ComponentConnector getChildComponent(
            com.google.gwt.user.client.Element element);

    protected ComponentConnector getChildComponent(NativeEvent event) {
        return getChildComponent((com.google.gwt.user.client.Element) event
                .getEventTarget().cast());
    }

    @Override
    protected void fireClick(NativeEvent event) {
        MouseEventDetails mouseDetails = MouseEventDetailsBuilder
                .buildMouseEventDetails(event, getRelativeToElement());
        getLayoutClickRPC().layoutClick(mouseDetails, getChildComponent(event));
    }

    protected abstract LayoutClickRpc getLayoutClickRPC();
}
