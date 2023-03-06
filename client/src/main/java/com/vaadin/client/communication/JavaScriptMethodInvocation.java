/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.communication;

import com.vaadin.shared.communication.MethodInvocation;

/**
 * A {@link MethodInvocation} that originates from JavaScript. This means that
 * there might not be any type information available on the client.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public class JavaScriptMethodInvocation extends MethodInvocation {

    public JavaScriptMethodInvocation(String connectorId, String interfaceName,
            String methodName, Object[] parameters) {
        super(connectorId, interfaceName, methodName, parameters);
    }
}
