/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.server;

import com.vaadin.server.AbstractExtension;
import com.vaadin.shared.communication.ClientRpc;
import com.vaadin.tests.widgetset.client.SerializerTestRpc;
import com.vaadin.tests.widgetset.client.SerializerTestState;

public class SerializerTestExtension extends AbstractExtension {

    @Override
    public <T extends ClientRpc> T getRpcProxy(Class<T> rpcInterface) {
        return super.getRpcProxy(rpcInterface);
    }

    @Override
    public SerializerTestState getState() {
        return (SerializerTestState) super.getState();
    }

    public void registerRpc(SerializerTestRpc rpc) {
        super.registerRpc(rpc);
    }

}
