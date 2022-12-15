/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.customcomponent;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ui.AbstractHasComponentsConnector;
import com.vaadin.client.ui.VCustomComponent;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.ui.CustomComponent;

@Connect(value = CustomComponent.class, loadStyle = LoadStyle.EAGER)
public class CustomComponentConnector extends AbstractHasComponentsConnector {

    @Override
    public VCustomComponent getWidget() {
        return (VCustomComponent) super.getWidget();
    }

    @Override
    public void updateCaption(ComponentConnector component) {
        // NOP, custom component dont render composition roots caption
    }

    @Override
    public void onConnectorHierarchyChange(
            ConnectorHierarchyChangeEvent event) {
        VCustomComponent customComponent = getWidget();
        if (getChildComponents().size() == 1) {
            ComponentConnector newChild = getChildComponents().get(0);
            customComponent.setWidget(newChild.getWidget());
        } else {
            customComponent.setWidget(null);
        }

    }
}
