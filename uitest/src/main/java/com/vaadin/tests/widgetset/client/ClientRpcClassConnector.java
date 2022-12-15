/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.vaadin.client.ui.label.LabelConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.MediaControl;
import com.vaadin.tests.widgetset.server.ClientRpcClassComponent;

@Connect(ClientRpcClassComponent.class)
public class ClientRpcClassConnector extends LabelConnector {

    @Override
    protected void init() {
        super.init();
        registerRpc(MediaControl.class, getWidget());
    }

    @Override
    public ClientRpcClassWidget getWidget() {
        return (ClientRpcClassWidget) super.getWidget();
    }
}
