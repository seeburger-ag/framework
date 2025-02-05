/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.client.ComponentConnector;
import com.vaadin.event.dd.DragSource;

/**
 * Client side counterpart for Transferable in com.vaadin.event.Transferable
 *
 */
public class VTransferable {

    private ComponentConnector component;

    private final Map<String, Object> variables = new HashMap<String, Object>();

    /**
     * Returns the component from which the transferable is created (eg. a tree
     * which node is dragged).
     *
     * @return the component
     */
    public ComponentConnector getDragSource() {
        return component;
    }

    /**
     * Sets the component currently being dragged or from which the transferable
     * is created (eg. a tree which node is dragged).
     * <p>
     * The server side counterpart of the component may implement
     * {@link DragSource} interface if it wants to translate or complement the
     * server side instance of this Transferable.
     *
     * @param component
     *            the component to set
     */
    public void setDragSource(ComponentConnector component) {
        this.component = component;
    }

    public Object getData(String dataFlavor) {
        return variables.get(dataFlavor);
    }

    public void setData(String dataFlavor, Object value) {
        variables.put(dataFlavor, value);
    }

    public Collection<String> getDataFlavors() {
        return variables.keySet();
    }

    /**
     * This helper method should only be called by {@link VDragAndDropManager}.
     *
     * @return data in this Transferable that needs to be moved to server.
     */
    Map<String, Object> getVariableMap() {
        return variables;
    }

}
