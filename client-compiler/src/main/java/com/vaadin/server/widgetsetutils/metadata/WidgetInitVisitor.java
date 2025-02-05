/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.widgetsetutils.metadata;

import java.util.Collection;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.annotations.DelegateToWidget;

public class WidgetInitVisitor extends TypeVisitor {

    @Override
    public void visitConnector(TreeLogger logger, JClassType type,
            ConnectorBundle bundle) throws UnableToCompleteException {
        if (ConnectorBundle.isConnectedComponentConnector(type)) {
            // The class in which createWidget is implemented
            JClassType createWidgetClass = ConnectorBundle
                    .findInheritedMethod(type, "createWidget")
                    .getEnclosingType();

            JMethod getWidget = ConnectorBundle.findInheritedMethod(type,
                    "getWidget");
            JClassType widgetType = getWidget.getReturnType().isClass();

            // Needs GWT constructor if createWidget is not overridden
            if (createWidgetClass.getQualifiedSourceName().equals(
                    AbstractComponentConnector.class.getCanonicalName())) {
                if (getWidget.getEnclosingType().getQualifiedSourceName()
                        .equals(AbstractComponentConnector.class
                                .getCanonicalName())) {
                    logger.log(Type.ERROR, type.getQualifiedSourceName()
                            + " must override either createWidget or getWidget");
                    throw new UnableToCompleteException();
                }

                bundle.setNeedsGwtConstructor(widgetType);

                // Also needs widget type to find the right GWT constructor
                bundle.setNeedsReturnType(type, getWidget);
            }

            // Check state properties for @DelegateToWidget
            JMethod getState = ConnectorBundle.findInheritedMethod(type,
                    "getState");
            JClassType stateType = getState.getReturnType().isClass();

            Collection<Property> properties = bundle.getProperties(stateType);
            for (Property property : properties) {
                DelegateToWidget delegateToWidget = property
                        .getAnnotation(DelegateToWidget.class);
                if (delegateToWidget != null) {
                    // Generate meta data required for @DelegateToWidget
                    bundle.setNeedsDelegateToWidget(property, stateType);

                    // Find the delegate target method
                    String methodName = DelegateToWidget.Helper
                            .getDelegateTarget(property.getName(),
                                    delegateToWidget.value());
                    JMethod delegatedSetter = ConnectorBundle
                            .findInheritedMethod(widgetType, methodName,
                                    property.getPropertyType());
                    if (delegatedSetter == null) {
                        logger.log(Type.ERROR,
                                widgetType.getName() + "." + methodName + "("
                                        + property.getPropertyType()
                                                .getSimpleSourceName()
                                        + ") required by @DelegateToWidget for "
                                        + stateType.getName() + "."
                                        + property.getName()
                                        + " can not be found.");
                        throw new UnableToCompleteException();
                    }
                    bundle.setNeedsInvoker(widgetType, delegatedSetter);

                    // GWT code needs widget type to find the target method
                    bundle.setNeedsReturnType(type, getWidget);
                }
            }

        }
    }
}
