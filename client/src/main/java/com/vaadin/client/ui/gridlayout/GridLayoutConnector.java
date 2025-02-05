/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.gridlayout;

import java.util.Map.Entry;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.DirectionalManagedLayout;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;
import com.vaadin.client.VCaption;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentContainerConnector;
import com.vaadin.client.ui.LayoutClickEventHandler;
import com.vaadin.client.ui.VGridLayout;
import com.vaadin.client.ui.VGridLayout.Cell;
import com.vaadin.client.ui.layout.VLayoutSlot;
import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.LayoutClickRpc;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.gridlayout.GridLayoutServerRpc;
import com.vaadin.shared.ui.gridlayout.GridLayoutState;
import com.vaadin.shared.ui.gridlayout.GridLayoutState.ChildComponentData;
import com.vaadin.ui.GridLayout;

@Connect(GridLayout.class)
public class GridLayoutConnector extends AbstractComponentContainerConnector
        implements DirectionalManagedLayout {

    private LayoutClickEventHandler clickEventHandler = new LayoutClickEventHandler(
            this) {

        @Override
        protected ComponentConnector getChildComponent(
                com.google.gwt.user.client.Element element) {
            return getWidget().getComponent(element);
        }

        @Override
        protected LayoutClickRpc getLayoutClickRPC() {
            return getRpcProxy(GridLayoutServerRpc.class);
        }

    };

    @Override
    public void init() {
        super.init();
        getWidget().client = getConnection();

        getLayoutManager().registerDependency(this,
                getWidget().spacingMeasureElement);
    }

    @Override
    public void onUnregister() {
        VGridLayout layout = getWidget();
        getLayoutManager().unregisterDependency(this,
                layout.spacingMeasureElement);

        // Unregister caption size dependencies
        for (ComponentConnector child : getChildComponents()) {
            Cell cell = layout.widgetToCell.get(child.getWidget());
            cell.slot.setCaption(null);
        }
    }

    @Override
    public GridLayoutState getState() {
        return (GridLayoutState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        clickEventHandler.handleEventHandlerRegistration();

        getWidget().hideEmptyRowsAndColumns = getState().hideEmptyRowsAndColumns;

        initSize();

        for (Entry<Connector, ChildComponentData> entry : getState().childData
                .entrySet()) {
            ComponentConnector child = (ComponentConnector) entry.getKey();

            Cell cell = getCell(child);

            ChildComponentData childComponentData = entry.getValue();
            cell.updateCell(childComponentData);
        }

        VGridLayout layout = getWidget();
        layout.colExpandRatioArray = getState().colExpand;
        layout.rowExpandRatioArray = getState().rowExpand;

        layout.updateMarginStyleNames(
                new MarginInfo(getState().marginsBitmask));
        layout.updateSpacingStyleName(getState().spacing);
        getLayoutManager().setNeedsLayout(this);
    }

    private Cell getCell(ComponentConnector child) {
        VGridLayout layout = getWidget();
        Cell cell = layout.widgetToCell.get(child.getWidget());

        if (cell == null) {
            ChildComponentData childComponentData = getState().childData
                    .get(child);
            int row = childComponentData.row1;
            int col = childComponentData.column1;

            cell = layout.createNewCell(row, col);
        }
        return cell;
    }

    @Override
    public void onConnectorHierarchyChange(
            ConnectorHierarchyChangeEvent event) {
        VGridLayout layout = getWidget();

        // clean non rendered components
        for (ComponentConnector oldChild : event.getOldChildren()) {
            if (oldChild.getParent() == this) {
                continue;
            }

            Widget childWidget = oldChild.getWidget();
            layout.remove(childWidget);
        }

        initSize();

        for (ComponentConnector componentConnector : getChildComponents()) {
            Cell cell = getCell(componentConnector);

            cell.setComponent(componentConnector, getChildComponents());
        }

    }

    private void initSize() {
        VGridLayout layout = getWidget();
        int cols = getState().columns;
        int rows = getState().rows;

        layout.columnWidths = new int[cols];
        layout.rowHeights = new int[rows];
        layout.explicitRowRatios = getState().explicitRowRatios;
        layout.explicitColRatios = getState().explicitColRatios;
        layout.setSize(rows, cols);
    }

    @Override
    public void updateCaption(ComponentConnector childConnector) {
        VGridLayout layout = getWidget();
        Cell cell = layout.widgetToCell.get(childConnector.getWidget());
        if (VCaption.isNeeded(childConnector.getState())) {
            VLayoutSlot layoutSlot = cell.slot;
            VCaption caption = layoutSlot.getCaption();
            if (caption == null) {
                caption = new VCaption(childConnector, getConnection());
                Widget widget = childConnector.getWidget();

                layout.setCaption(widget, caption);
            }
            caption.updateCaption();
        } else {
            layout.setCaption(childConnector.getWidget(), null);
            getLayoutManager().setNeedsLayout(this);
        }
    }

    @Override
    public VGridLayout getWidget() {
        return (VGridLayout) super.getWidget();
    }

    @Override
    public void layoutVertically() {
        getWidget().updateHeight();
    }

    @Override
    public void layoutHorizontally() {
        getWidget().updateWidth();
    }

    @Override
    protected void updateWidgetSize(String newWidth, String newHeight) {
        // Prevent the element from momentarily shrinking to zero size
        // when the size is set to undefined by a state change but before
        // it is recomputed in the layout phase. This may affect scroll
        // position in some cases; see #13386.
        if (!isUndefinedHeight()) {
            getWidget().setHeight(newHeight);
        }
        if (!isUndefinedWidth()) {
            getWidget().setWidth(newWidth);
        }
    }
}
