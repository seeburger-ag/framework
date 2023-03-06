/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client;

import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasWidgets;
import com.vaadin.client.ConnectorHierarchyChangeEvent.ConnectorHierarchyChangeHandler;
import com.vaadin.ui.HasComponents;

/**
 * An interface used by client-side connectors whose widget is a component
 * container (implements {@link HasWidgets}).
 */
public interface HasComponentsConnector extends ServerConnector {

    /**
     * Update child components caption, description and error message.
     *
     * <p>
     * Each component is responsible for maintaining its caption, description
     * and error message. In most cases components doesn't want to do that and
     * those elements reside outside of the component. Because of this layouts
     * must provide service for it's childen to show those elements for them.
     * </p>
     *
     * @param connector
     *            Child component for which service is requested.
     */
    void updateCaption(ComponentConnector connector);

    /**
     * Returns the child components for this connector.
     * <p>
     * The children for this connector are defined as all {@link HasComponents}s
     * whose parent is this {@link HasComponentsConnector}.
     * <p>
     * Note that the method {@link ServerConnector#getChildren()} can return a
     * larger list of children including both the child components and any
     * extensions registered for the connector.
     *
     * @return A collection of child components for this connector. An empty
     *         collection if there are no children. Never returns null.
     */
    public List<ComponentConnector> getChildComponents();

    /**
     * Sets the children for this connector. This method should only be called
     * by the framework to ensure that the connector hierarchy on the client
     * side and the server side are in sync.
     * <p>
     * Note that calling this method does not call
     * {@link ConnectorHierarchyChangeHandler#onConnectorHierarchyChange(ConnectorHierarchyChangeEvent)}
     * . The event method is called only when the hierarchy has been updated for
     * all connectors.
     * <p>
     * Note that this method is separate from
     * {@link ServerConnector#setChildren(List)} and contains only child
     * components. Both methods are called separately by the framework if the
     * connector implements {@link HasComponentsConnector}.
     *
     * @param children
     *            The new child connectors (components only)
     */
    public void setChildComponents(List<ComponentConnector> children);

    /**
     * Adds a handler that is called whenever the child hierarchy of this
     * connector has been updated by the server.
     *
     * @param handler
     *            The handler that should be added.
     * @return A handler registration reference that can be used to unregister
     *         the handler
     */
    public HandlerRegistration addConnectorHierarchyChangeHandler(
            ConnectorHierarchyChangeHandler handler);

}
