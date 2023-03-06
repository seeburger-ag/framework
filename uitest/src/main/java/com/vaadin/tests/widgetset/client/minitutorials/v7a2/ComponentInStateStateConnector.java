/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client.minitutorials.v7a2;

import com.google.gwt.user.client.ui.Label;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.minitutorials.v7a2.ComponentInStateComponent;

@Connect(ComponentInStateComponent.class)
public class ComponentInStateStateConnector extends AbstractComponentConnector {
    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        getWidget().setText("Client-side type of other component: "
                + getOtherComponent().getClass().getName());
    }

    public ComponentConnector getOtherComponent() {
        return (ComponentConnector) getState().otherComponent;
    }

    @Override
    public ComponentInStateState getState() {
        return (ComponentInStateState) super.getState();
    }

    @Override
    public Label getWidget() {
        return (Label) super.getWidget();
    }
}
