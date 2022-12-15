/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server.widgetsetutils.metadata;

import java.util.Set;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.vaadin.client.metadata.TypeDataStore.MethodAttribute;
import com.vaadin.shared.annotations.NoLoadingIndicator;
import com.vaadin.shared.annotations.Delayed;

public class ServerRpcVisitor extends TypeVisitor {
    @Override
    public void visitServerRpc(TreeLogger logger, JClassType type,
            ConnectorBundle bundle) throws UnableToCompleteException {
        ClientRpcVisitor.checkGenericType(logger, type);
        bundle.setNeedsProxySupport(type);

        Set<? extends JClassType> superTypes = type
                .getFlattenedSupertypeHierarchy();
        for (JClassType subType : superTypes) {
            if (subType.isInterface() != null) {
                JMethod[] methods = subType.getMethods();
                for (JMethod method : methods) {
                    ClientRpcVisitor.checkReturnType(logger, method);

                    Delayed delayed = method.getAnnotation(Delayed.class);
                    if (delayed != null) {
                        bundle.setMethodAttribute(type, method,
                                MethodAttribute.DELAYED);
                        if (delayed.lastOnly()) {
                            bundle.setMethodAttribute(type, method,
                                    MethodAttribute.LAST_ONLY);
                        }
                    }

                    if (method
                            .getAnnotation(NoLoadingIndicator.class) != null) {
                        bundle.setMethodAttribute(type, method,
                                MethodAttribute.NO_LOADING_INDICATOR);
                    }

                    bundle.setNeedsParamTypes(type, method);

                    JType[] parameterTypes = method.getParameterTypes();
                    for (JType paramType : parameterTypes) {
                        bundle.setNeedsSerialize(paramType);
                    }
                }
            }
        }
    }
}
