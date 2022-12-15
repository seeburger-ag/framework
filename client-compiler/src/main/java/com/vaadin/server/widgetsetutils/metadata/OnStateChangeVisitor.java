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
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.shared.ui.Connect;

/**
 * Visits Connector classes and check for methods with @OnStateChange
 * annotations.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class OnStateChangeVisitor extends TypeVisitor {

    @Override
    public void visitConnector(TreeLogger logger, JClassType type,
            ConnectorBundle bundle) throws UnableToCompleteException {
        Connect connectAnnotation = type.getAnnotation(Connect.class);
        if (connectAnnotation != null) {
            // Find all the annotated methods in all the superclasses
            JClassType connector = type;
            while (connector != null) {
                for (JMethod method : connector.getMethods()) {
                    if (method.getAnnotation(OnStateChange.class) != null) {
                        bundle.setNeedsInvoker(connector, method);
                        bundle.setNeedsOnStateChangeHandler(type, method);
                    }
                }

                connector = connector.getSuperclass();
            }
        }
    }

}
