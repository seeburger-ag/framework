/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.browserframe;

import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.VBrowserFrame;
import com.vaadin.shared.ui.AbstractEmbeddedState;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.browserframe.BrowserFrameState;

@Connect(com.vaadin.ui.BrowserFrame.class)
public class BrowserFrameConnector extends AbstractComponentConnector {

    @Override
    public VBrowserFrame getWidget() {
        return (VBrowserFrame) super.getWidget();
    }

    @Override
    public BrowserFrameState getState() {
        return (BrowserFrameState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {

        super.onStateChanged(stateChangeEvent);

        getWidget().setAlternateText(getState().alternateText);
        getWidget().setSource(
                getResourceUrl(AbstractEmbeddedState.SOURCE_RESOURCE));
        getWidget().setName(getConnectorId());
    }

}
