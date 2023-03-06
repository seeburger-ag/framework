/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.communication;

import com.vaadin.client.ServerConnector;
import com.vaadin.client.metadata.InvokationHandler;
import com.vaadin.client.metadata.Method;
import com.vaadin.client.metadata.NoDataException;
import com.vaadin.client.metadata.TypeData;
import com.vaadin.shared.communication.MethodInvocation;
import com.vaadin.shared.communication.ServerRpc;

/**
 * Class for creating proxy instances for Client to Server RPC.
 *
 * @since 7.0
 */
public class RpcProxy {

    public static <T extends ServerRpc> T create(Class<T> rpcInterface,
            ServerConnector connector) {
        try {
            return (T) TypeData.getType(rpcInterface).createProxy(
                    new RpcInvokationHandler(rpcInterface, connector));
        } catch (NoDataException e) {
            throw new IllegalStateException(
                    "There is no information about " + rpcInterface
                            + ". Did you forget to compile the widgetset?");
        }
    }

    private static final class RpcInvokationHandler
            implements InvokationHandler {
        private final Class<?> rpcInterface;
        private final ServerConnector connector;

        private RpcInvokationHandler(Class<?> rpcInterface,
                ServerConnector connector) {
            this.rpcInterface = rpcInterface;
            this.connector = connector;
        }

        @Override
        public Object invoke(Object target, Method method, Object[] params) {
            MethodInvocation invocation = new MethodInvocation(
                    connector.getConnectorId(), rpcInterface.getName(),
                    method.getName(), params);
            ServerRpcQueue serverRpcQueue = ServerRpcQueue
                    .get(connector.getConnection());
            serverRpcQueue.add(invocation, method.isLastOnly());
            if (!method.isDelayed()) {
                serverRpcQueue.flush();
            }
            // No RPC iface should have a return value
            return null;
        }
    }
}
