/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import java.util.Collections;
import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ConnectorHierarchyChangeEvent.ConnectorHierarchyChangeHandler;
import com.vaadin.client.HasComponentsConnector;

public abstract class AbstractHasComponentsConnector
        extends AbstractComponentConnector
        implements HasComponentsConnector, ConnectorHierarchyChangeHandler {

    List<ComponentConnector> childComponents;

    /**
     * Default constructor
     */
    public AbstractHasComponentsConnector() {
        addConnectorHierarchyChangeHandler(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.client.HasComponentsConnector#getChildren()
     */
    @Override
    public List<ComponentConnector> getChildComponents() {
        if (childComponents == null) {
            return Collections.emptyList();
        }

        return childComponents;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.client.HasComponentsConnector#setChildren
     * (java.util.Collection)
     */
    @Override
    public void setChildComponents(List<ComponentConnector> childComponents) {
        this.childComponents = childComponents;
    }

    @Override
    public HandlerRegistration addConnectorHierarchyChangeHandler(
            ConnectorHierarchyChangeHandler handler) {
        return ensureHandlerManager()
                .addHandler(ConnectorHierarchyChangeEvent.TYPE, handler);
    }
}
