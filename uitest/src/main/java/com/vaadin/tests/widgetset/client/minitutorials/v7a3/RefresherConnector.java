/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.minitutorials.v7a3;

import com.google.gwt.user.client.Timer;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.minitutorials.v7a3.Refresher;

@Connect(Refresher.class)
public class RefresherConnector extends AbstractExtensionConnector {

    private Timer timer = new Timer() {
        @Override
        public void run() {
            getRpcProxy(RefresherRpc.class).refresh();
        }
    };

    @Override
    public void onStateChanged(StateChangeEvent event) {
        super.onStateChanged(event);
        timer.cancel();
        if (isEnabled()) {
            timer.scheduleRepeating(getState().interval);
        }
    }

    @Override
    public void onUnregister() {
        timer.cancel();
    }

    @Override
    protected void extend(ServerConnector target) {
        // Nothing for refresher to do here as it does not need to access the
        // connector it extends
    }

    @Override
    public RefresherState getState() {
        return (RefresherState) super.getState();
    }
}
