/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.widgetsetutils.metadata;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;

public class StateInitVisitor extends TypeVisitor {
    @Override
    public void visitConnector(TreeLogger logger, JClassType type,
            ConnectorBundle bundle) {
        JMethod getState = ConnectorBundle.findInheritedMethod(type,
                "getState");
        bundle.setNeedsReturnType(type, getState);

        bundle.setNeedsSerialize(getState.getReturnType());

        JType stateType = getState.getReturnType();
        bundle.setNeedsGwtConstructor(stateType.isClass());
    }

}
