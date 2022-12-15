/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.colorpicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.colorpicker.ColorPickerGridServerRpc;
import com.vaadin.shared.ui.colorpicker.ColorPickerGridState;
import com.vaadin.ui.components.colorpicker.ColorPickerGrid;

/**
 * A class that defines the default implementation for a color picker grid
 * connector. Connects the server side {@link ColorPickerGrid} with the client
 * side counterpart {@link VColorPickerGrid}
 *
 * @since 7.0.0
 */
@Connect(value = ColorPickerGrid.class, loadStyle = LoadStyle.LAZY)
public class ColorPickerGridConnector extends AbstractComponentConnector
        implements ClickHandler {

    private ColorPickerGridServerRpc rpc = RpcProxy
            .create(ColorPickerGridServerRpc.class, this);

    @Override
    protected Widget createWidget() {
        return GWT.create(VColorPickerGrid.class);
    }

    @Override
    public VColorPickerGrid getWidget() {
        return (VColorPickerGrid) super.getWidget();
    }

    @Override
    public ColorPickerGridState getState() {
        return (ColorPickerGridState) super.getState();
    }

    @Override
    public void onClick(ClickEvent event) {
        rpc.select(getWidget().getSelectedX(), getWidget().getSelectedY());
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (stateChangeEvent.hasPropertyChanged("rowCount")
                || stateChangeEvent.hasPropertyChanged("columnCount")
                || stateChangeEvent.hasPropertyChanged("updateGrid")) {

            getWidget().updateGrid(getState().rowCount, getState().columnCount);
        }
        if (stateChangeEvent.hasPropertyChanged("changedX")
                || stateChangeEvent.hasPropertyChanged("changedY")
                || stateChangeEvent.hasPropertyChanged("changedColor")
                || stateChangeEvent.hasPropertyChanged("updateColor")) {

            getWidget().updateColor(getState().changedColor,
                    getState().changedX, getState().changedY);

            if (!getWidget().isGridLoaded()) {
                rpc.refresh();
            }
        }
    }

    @Override
    protected void init() {
        super.init();
        getWidget().addClickHandler(this);
    }
}
