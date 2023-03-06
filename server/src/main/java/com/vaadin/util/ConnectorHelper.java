/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.util;

import java.util.LinkedList;

import com.vaadin.server.ClientConnector;
import com.vaadin.ui.Component;

/**
 * Provides various helper methods for connectors. Meant for internal use.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public class ConnectorHelper {

    /**
     * Creates a string containing debug info for the connector
     *
     * @since 7.1
     * @param connector
     *            The connector to print debug info about
     * @return A string with debug information
     */
    public static String getDebugInformation(ClientConnector connector) {
        StringBuilder sb = new StringBuilder();
        sb.append("*** Debug details of a connector:  *** \n");
        sb.append("Type: ");
        sb.append(connector.getClass().getName());
        sb.append("\nId:");
        sb.append(connector.getConnectorId());
        if (connector instanceof Component) {
            Component component = (Component) connector;
            if (component.getCaption() != null) {
                sb.append("\nCaption:");
                sb.append(component.getCaption());
            }
        }
        writeHierarchyInformation(connector, sb);
        return sb.toString();
    }

    /**
     * Creates a string containing hierarchy information for the connector
     *
     * @since 7.1
     * @param connector
     *            The connector to get hierarchy information for
     * @param builder
     *            The StringBuilder where the information should be written
     */
    public static void writeHierarchyInformation(ClientConnector connector,
            StringBuilder builder) {
        LinkedList<ClientConnector> h = new LinkedList<ClientConnector>();
        h.add(connector);
        ClientConnector parent = connector.getParent();
        while (parent != null) {
            h.addFirst(parent);
            parent = parent.getParent();
        }

        builder.append("\nConnector hierarchy:\n");

        int l = 0;
        for (ClientConnector connector2 : h) {
            if (l != 0) {
                builder.append("\n");
                for (int i = 0; i < l; i++) {
                    builder.append("  ");
                }
            }
            l++;
            Class<? extends ClientConnector> connectorClass = connector2
                    .getClass();
            Class<?> topClass = connectorClass;
            while (topClass.getEnclosingClass() != null) {
                topClass = topClass.getEnclosingClass();
            }
            builder.append(connectorClass.getName());
            builder.append("(");
            builder.append(topClass.getSimpleName());
            builder.append(".java:1)");
        }
    }

}
