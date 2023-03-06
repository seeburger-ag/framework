/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.vaadin.shared.communication.MethodInvocation;
import com.vaadin.shared.communication.ServerRpc;

public class ServerRpcMethodInvocation extends MethodInvocation {

    private static final Map<String, Method> invocationMethodCache = new ConcurrentHashMap<String, Method>(
            128, 0.75f, 1);

    private final Method method;

    private final Class<? extends ServerRpc> interfaceClass;

    public ServerRpcMethodInvocation(String connectorId,
            Class<? extends ServerRpc> interfaceClass, String methodName,
            int parameterCount) {
        super(connectorId, interfaceClass.getName(), methodName);

        assert ServerRpc.class.isAssignableFrom(interfaceClass);
        this.interfaceClass = interfaceClass;

        method = findInvocationMethod(interfaceClass, methodName,
                parameterCount);
    }

    public Class<? extends ServerRpc> getInterfaceClass() {
        return interfaceClass;
    }

    public Method getMethod() {
        return method;
    }

    /**
     * Tries to find the method from the cache or alternatively by invoking
     * {@link #doFindInvocationMethod(Class, String, int)} and updating the
     * cache.
     *
     * @param targetType
     * @param methodName
     * @param parameterCount
     * @return
     */
    private Method findInvocationMethod(Class<?> targetType, String methodName,
            int parameterCount) {
        // TODO currently only using method name and number of parameters as the
        // signature
        String signature = targetType.getName() + "." + methodName + "("
                + parameterCount;
        Method invocationMethod = invocationMethodCache.get(signature);

        if (invocationMethod == null) {
            invocationMethod = doFindInvocationMethod(targetType, methodName,
                    parameterCount);

            if (invocationMethod != null) {
                invocationMethodCache.put(signature, invocationMethod);
            }
        }

        if (invocationMethod == null) {
            throw new IllegalStateException("Can't find method " + methodName
                    + " with " + parameterCount + " parameters in "
                    + targetType.getName());
        }

        return invocationMethod;
    }

    /**
     * Tries to find the method from the class by looping through available
     * methods.
     *
     * @param targetType
     * @param methodName
     * @param parameterCount
     * @return
     */
    private Method doFindInvocationMethod(Class<?> targetType,
            String methodName, int parameterCount) {
        Method[] methods = targetType.getMethods();
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (method.getName().equals(methodName)
                    && parameterTypes.length == parameterCount) {
                return method;
            }
        }
        return null;
    }

}
