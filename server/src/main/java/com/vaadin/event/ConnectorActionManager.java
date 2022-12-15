/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.event;

import java.util.logging.Logger;

import com.vaadin.event.Action.Container;
import com.vaadin.server.ClientConnector;
import com.vaadin.server.VariableOwner;
import com.vaadin.ui.Component;

/**
 * An ActionManager connected to a connector. Takes care of verifying that the
 * connector can receive events before triggering an action.
 * <p>
 * This is mostly a workaround until shortcut actions are re-implemented in a
 * more sensible way.
 *
 * @since 7.1.8
 * @author Vaadin Ltd
 */
public class ConnectorActionManager extends ActionManager {

    private ClientConnector connector;

    /**
     * Initialize an action manager for the given connector.
     *
     * @param connector
     *            the owner of this action manager
     */
    public ConnectorActionManager(ClientConnector connector) {
        super();
        this.connector = connector;
    }

    /**
     * Initialize an action manager for the given connector using the given
     * viewer.
     *
     * @param connector
     *            the owner of this action manager
     * @param viewer
     *            the viewer connected
     */
    public <T extends Component & Container & VariableOwner> ConnectorActionManager(
            ClientConnector connector, T viewer) {
        super(viewer);
        this.connector = connector;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.event.ActionManager#handleAction(com.vaadin.event.Action,
     * java.lang.Object, java.lang.Object)
     */
    @Override
    public void handleAction(Action action, Object sender, Object target) {
        if (!connector.isConnectorEnabled()) {
            return;
        }

        super.handleAction(action, sender, target);
    }

    private static final Logger getLogger() {
        return Logger.getLogger(ConnectorActionManager.class.getName());
    }

}
