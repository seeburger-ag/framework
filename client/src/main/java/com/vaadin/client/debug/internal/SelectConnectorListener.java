/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.debug.internal;

import com.google.gwt.dom.client.Element;
import com.vaadin.client.ServerConnector;

/**
 * Listener for the selection of a connector in the debug window.
 *
 * @since 7.1.4
 */
public interface SelectConnectorListener {
    /**
     * Listener method called when a connector has been selected. If a specific
     * element of the connector was selected, it is also given.
     *
     * @param connector
     *            selected connector
     * @param element
     *            selected element of the connector or null if unknown
     */
    public void select(ServerConnector connector, Element element);
}
