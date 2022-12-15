/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.progressindicator;

import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.client.ui.VProgressBar;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.progressindicator.ProgressBarState;
import com.vaadin.ui.ProgressBar;

/**
 * Connector for {@link VProgressBar}.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
@Connect(ProgressBar.class)
public class ProgressBarConnector extends AbstractFieldConnector {

    public ProgressBarConnector() {
        super();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setIndeterminate(getState().indeterminate);
        getWidget().setState(getState().state);
    }

    @Override
    public ProgressBarState getState() {
        return (ProgressBarState) super.getState();
    }

    @Override
    public VProgressBar getWidget() {
        return (VProgressBar) super.getWidget();
    }

}
