/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;

/**
 * Client side connector for subclasses of AbstractSingleComponentConnector.
 *
 * @since 7.0
 */
public abstract class AbstractSingleComponentContainerConnector
        extends AbstractHasComponentsConnector {

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
