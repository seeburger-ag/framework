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
import com.vaadin.tests.widgetset.server.GenericWidgetComponent;

@Connect(GenericWidgetComponent.class)
public class GenericWidgetConnector extends AbstractComponentConnector {
    @Override
    public GenericWidget<String> getWidget() {
        return (GenericWidget<String>) super.getWidget();
    }

    @Override
    public GenericWidgetState getState() {
        return (GenericWidgetState) super.getState();
    }
}
