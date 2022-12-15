/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.progressindicator;

import com.google.gwt.user.client.Timer;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.VProgressBar;
import com.vaadin.client.ui.VProgressIndicator;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.progressindicator.ProgressIndicatorServerRpc;
import com.vaadin.shared.ui.progressindicator.ProgressIndicatorState;
import com.vaadin.ui.ProgressIndicator;

/**
 * Connector for {@link VProgressBar} with polling support.
 *
 * @since 7.0
 * @author Vaadin Ltd
 * @deprecated as of 7.1, use {@link ProgressBarConnector} combined with server
 *             push or UI polling.
 */
@Connect(ProgressIndicator.class)
@Deprecated
public class ProgressIndicatorConnector extends ProgressBarConnector {

    @Override
    public ProgressIndicatorState getState() {
        return (ProgressIndicatorState) super.getState();
    }

    private Timer poller = new Timer() {

        @Override
        public void run() {
            getRpcProxy(ProgressIndicatorServerRpc.class).poll();
        }

    };

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        if (isEnabled()) {
            poller.scheduleRepeating(getState().pollingInterval);
        } else {
            poller.cancel();
        }
    }

    @Override
    public VProgressIndicator getWidget() {
        return (VProgressIndicator) super.getWidget();
    }

    @Override
    public void onUnregister() {
        super.onUnregister();
        poller.cancel();
    }
}
