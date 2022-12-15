/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.vaadin.shared.JavaScriptConnectorState;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScript.JavaScriptCallbackRpc;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.util.ReflectTools;

import elemental.json.JsonArray;
import elemental.json.JsonException;

/**
 * Internal helper class used to implement functionality common to
 * {@link AbstractJavaScriptComponent} and {@link AbstractJavaScriptExtension}.
 * Corresponding support in client-side code is in
 * {@link com.vaadin.client.JavaScriptConnectorHelper}.
 * <p>
 * You should most likely no use this class directly.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public class JavaScriptCallbackHelper implements Serializable {

    private static final Method CALL_METHOD = ReflectTools.findMethod(
            JavaScriptCallbackRpc.class, "call", String.class, JsonArray.class);
    private AbstractClientConnector connector;

    private Map<String, JavaScriptFunction> callbacks = new HashMap<String, JavaScriptFunction>();
    private JavaScriptCallbackRpc javascriptCallbackRpc;

    public JavaScriptCallbackHelper(AbstractClientConnector connector) {
        this.connector = connector;
    }

    public void registerCallback(String functionName,
            JavaScriptFunction javaScriptCallback) {
        callbacks.put(functionName, javaScriptCallback);
        JavaScriptConnectorState state = getConnectorState();
        state.getCallbackNames().add(functionName);
        ensureRpc();
    }

    private JavaScriptConnectorState getConnectorState() {
        JavaScriptConnectorState state = (JavaScriptConnectorState) connector
                .getState();
        return state;
    }

    private void ensureRpc() {
        if (javascriptCallbackRpc == null) {
            javascriptCallbackRpc = new JavaScriptCallbackRpc() {
                @Override
                public void call(String name, JsonArray arguments) {
                    JavaScriptFunction callback = callbacks.get(name);
                    try {
                        callback.call(arguments);
                    } catch (JsonException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            };
            connector.registerRpc(javascriptCallbackRpc);
        }
    }

    public void invokeCallback(String name, Object... arguments) {
        if (callbacks.containsKey(name)) {
            throw new IllegalStateException("Can't call callback " + name
                    + " on the client because a callback with the same name is registered on the server.");
        }
        JsonArray args = (JsonArray) JsonCodec
                .encode(arguments, null, Object[].class, null)
                .getEncodedValue();
        connector.addMethodInvocationToQueue(
                JavaScriptCallbackRpc.class.getName(), CALL_METHOD,
                new Object[] { name, args });
    }

    public void registerRpc(Class<?> rpcInterfaceType) {
        if (rpcInterfaceType == JavaScriptCallbackRpc.class) {
            // Ignore
            return;
        }
        Map<String, Set<String>> rpcInterfaces = getConnectorState()
                .getRpcInterfaces();
        String interfaceName = rpcInterfaceType.getName();
        if (!rpcInterfaces.containsKey(interfaceName)) {
            Set<String> methodNames = new HashSet<String>();

            for (Method method : rpcInterfaceType.getMethods()) {
                methodNames.add(method.getName());
            }

            rpcInterfaces.put(interfaceName, methodNames);
        }
    }

}
