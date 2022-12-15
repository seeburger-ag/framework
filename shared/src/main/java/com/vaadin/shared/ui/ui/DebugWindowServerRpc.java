/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.shared.ui.ui;

import com.vaadin.shared.Connector;
import com.vaadin.shared.communication.ServerRpc;

/**
 * Server RPC methods for the Debug Window.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public interface DebugWindowServerRpc extends ServerRpc {
    /**
     * Sends a request to the server to print details to console that will help
     * the developer to locate the corresponding server-side connector in the
     * source code.
     *
     * @since 7.1
     * @param connector
     *            the connector to locate
     **/
    public void showServerDebugInfo(Connector connector);

    /**
     * Invokes the layout analyzer on the server
     *
     * @since 7.1
     */
    public void analyzeLayouts();

    /**
     * Sends a request to the server to print a design to the console for the
     * given component.
     *
     * @since 7.5
     * @param connector
     *            the component connector to output a declarative design for
     */
    public void showServerDesign(Connector connector);

}
