/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui;

import com.vaadin.shared.Connector;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface LayoutClickRpc extends ServerRpc {
    /**
     * Called when a layout click event has occurred and there are server side
     * listeners for the event.
     *
     * @param mouseDetails
     *            Details about the mouse when the event took place
     * @param clickedConnector
     *            The child component that was the target of the event
     */
    public void layoutClick(MouseEventDetails mouseDetails,
            Connector clickedConnector);
}
