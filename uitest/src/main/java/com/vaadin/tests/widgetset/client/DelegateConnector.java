/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client;

import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.DelegateToWidgetComponent;

@Connect(DelegateToWidgetComponent.class)
public class DelegateConnector extends AbstractComponentConnector {
    @Override
    public DelegateWidget getWidget() {
        return (DelegateWidget) super.getWidget();
    }

    @Override
    public DelegateState getState() {
        return (DelegateState) super.getState();
    }
}
