/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.WidgetUtilUI.WidgetUtilTestComponent;

@Connect(WidgetUtilTestComponent.class)
public class WidgetUtilTestConnector extends AbstractComponentConnector {

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().construct(getState().inline);

    }

    @Override
    public WidgetUtilTestWidget getWidget() {
        return (WidgetUtilTestWidget) super.getWidget();
    }

    @Override
    public WidgetUtilTestComponentState getState() {
        return (WidgetUtilTestComponentState) super.getState();
    }

}
