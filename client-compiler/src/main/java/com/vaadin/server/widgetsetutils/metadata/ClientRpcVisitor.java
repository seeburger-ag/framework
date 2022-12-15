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
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.vaadin.client.metadata.TypeDataStore.MethodAttribute;
import com.vaadin.shared.annotations.NoLayout;

public class ClientRpcVisitor extends TypeVisitor {
    @Override
    public void visitClientRpc(TreeLogger logger, JClassType type,
            ConnectorBundle bundle) throws UnableToCompleteException {
        checkGenericType(logger, type);
        Set<? extends JClassType> hierarchy = type
                .getFlattenedSupertypeHierarchy();
        for (JClassType subType : hierarchy) {
            JMethod[] methods = subType.getMethods();
            for (JMethod method : methods) {
                checkReturnType(logger, method);

                bundle.setNeedsInvoker(type, method);
                bundle.setNeedsParamTypes(type, method);
                if (method.getAnnotation(NoLayout.class) != null) {
                    bundle.setMethodAttribute(type, method,
                            MethodAttribute.NO_LAYOUT);
                }

                JType[] parameterTypes = method.getParameterTypes();
                for (JType paramType : parameterTypes) {
                    bundle.setNeedsSerialize(paramType);
                }
            }
        }
    }

    public static void checkGenericType(TreeLogger logger, JClassType type)
            throws UnableToCompleteException {
        if (type.isGenericType() != null) {
            logger.log(Type.ERROR,
                    "Type " + type.getParameterizedQualifiedSourceName()
                            + "is parameterizied generic. RPC proxy "
                            + "for parameterizied types is not supported.");
            throw new UnableToCompleteException();
        }
    }

    public static void checkReturnType(TreeLogger logger, JMethod method)
            throws UnableToCompleteException {
        if (!method.getReturnType().getQualifiedSourceName().equals("void")) {
            logger.log(Type.ERROR, "The method "
                    + method.getEnclosingType().getQualifiedSourceName() + "."
                    + method.getName() + " returns "
                    + method.getReturnType().getQualifiedSourceName()
                    + " but only void is supported for methods in RPC interfaces.");
            throw new UnableToCompleteException();
        }
    }
}
