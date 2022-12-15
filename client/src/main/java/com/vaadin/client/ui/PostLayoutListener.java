/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.LayoutManager;

/**
 * Interface implemented by {@link ComponentConnector} implementations that want
 * to know whenever a layout phase has ended. At the end of each layout phase,
 * {@link LayoutManager} invokes the {@link #postLayout()} method for all
 * registered component connectors implementing this interface.
 *
 * @since 7.0
 * @author Vaadin Ltd
 */
public interface PostLayoutListener {
    /**
     * Method invoked by {@link LayoutManager} to notify the connector that a
     * layout phase has ended. This method can be used to finalize internal
     * layouting, but it is not allowed to change the its own external size or
     * modify the conditions for any children.
     */
    public void postLayout();
}
