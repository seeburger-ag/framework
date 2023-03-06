/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.ui.VGridLayout;
import com.vaadin.client.ui.gridlayout.GridLayoutConnector;
import com.vaadin.client.ui.layout.MayScrollChildren;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.ScrollableGridLayout;

@Connect(ScrollableGridLayout.class)
public class ScrollableGridLayoutConnector extends GridLayoutConnector
        implements MayScrollChildren {
    @Override
    public void onConnectorHierarchyChange(
            ConnectorHierarchyChangeEvent event) {
        super.onConnectorHierarchyChange(event);

        for (VGridLayout.Cell cell : getWidget().widgetToCell.values()) {
            cell.slot.getWrapperElement().addClassName("v-scrollable");
        }
    }
}
