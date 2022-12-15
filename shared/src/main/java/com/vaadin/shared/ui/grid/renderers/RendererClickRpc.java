/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid.renderers;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface RendererClickRpc extends ServerRpc {
    /**
     * Called when a click event has occurred and there are server side
     * listeners for the event.
     *
     * @param mouseDetails
     *            Details about the mouse when the event took place
     */
    public void click(String rowKey, String columnId,
            MouseEventDetails mouseDetails);
}
