/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.customfield;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ConnectorHierarchyChangeEvent.ConnectorHierarchyChangeHandler;
import com.vaadin.client.Focusable;
import com.vaadin.client.HasComponentsConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.client.ui.VCustomField;
import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.CustomField;

@Connect(value = CustomField.class)
public class CustomFieldConnector extends AbstractFieldConnector
        implements HasComponentsConnector, ConnectorHierarchyChangeHandler {

    List<ComponentConnector> childComponents;

    /**
     * Default constructor
     */
    public CustomFieldConnector() {
        addConnectorHierarchyChangeHandler(this);
    }

    @Override
    public VCustomField getWidget() {
        return (VCustomField) super.getWidget();
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // NOP, custom field does not render the caption of its content
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (getState().focusDelegate != null) {
            Widget widget = ((ComponentConnector) getState().focusDelegate)
                    .getWidget();
            if (widget instanceof Focusable) {
                getWidget().setFocusDelegate((Focusable) widget);
            } else if (widget instanceof com.google.gwt.user.client.ui.Focusable) {
                getWidget().setFocusDelegate(
                        (com.google.gwt.user.client.ui.Focusable) widget);
            } else {
                getLogger().warning(
                        "The given focus delegate does not implement Focusable: "
                                + widget.getClass().getName());
            }
        } else {
            getWidget().setFocusDelegate((Focusable) null);
        }

    }

    private static Logger getLogger() {
        return Logger.getLogger(CustomFieldConnector.class.getName());
    }

    @Override
    public void onConnectorHierarchyChange(
            ConnectorHierarchyChangeEvent event) {
        // We always have 1 child, unless the child is hidden
        getWidget().setWidget(getContentWidget());
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

    /**
     * Returns the content (only/first child) of the container.
     *
     * @return child connector or null if none (e.g. invisible or not set on
     *         server)
     */
    protected ComponentConnector getContent() {
        List<ComponentConnector> children = getChildComponents();
        if (children.isEmpty()) {
            return null;
        } else {
            return children.get(0);
        }
    }

    /**
     * Returns the widget (if any) of the content of the container.
     *
     * @return widget of the only/first connector of the container, null if no
     *         content or if there is no widget for the connector
     */
    protected Widget getContentWidget() {
        ComponentConnector content = getContent();
        if (null != content) {
            return content.getWidget();
        } else {
            return null;
        }
    }

}
