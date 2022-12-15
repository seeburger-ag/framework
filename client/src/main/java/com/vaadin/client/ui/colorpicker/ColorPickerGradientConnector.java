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
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.colorpicker.ColorPickerGradientServerRpc;
import com.vaadin.shared.ui.colorpicker.ColorPickerGradientState;
import com.vaadin.ui.components.colorpicker.ColorPickerGradient;

/**
 * A class that defines the default implementation for a color picker gradient
 * connector. Connects the server side {@link ColorPickerGradient} with the
 * client side counterpart {@link VColorPickerGradient}
 *
 * @since 7.0.0
 */
@Connect(value = ColorPickerGradient.class, loadStyle = LoadStyle.LAZY)
public class ColorPickerGradientConnector extends AbstractComponentConnector
        implements MouseUpHandler {

    private ColorPickerGradientServerRpc rpc = RpcProxy
            .create(ColorPickerGradientServerRpc.class, this);

    @Override
    protected Widget createWidget() {
        return GWT.create(VColorPickerGradient.class);
    }

    @Override
    public VColorPickerGradient getWidget() {
        return (VColorPickerGradient) super.getWidget();
    }

    @Override
    public ColorPickerGradientState getState() {
        return (ColorPickerGradientState) super.getState();
    }

    @Override
    public void onMouseUp(MouseUpEvent event) {
        rpc.select(getWidget().getCursorX(), getWidget().getCursorY());
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        if (stateChangeEvent.hasPropertyChanged("cursorX")
                || stateChangeEvent.hasPropertyChanged("cursorY")) {

            getWidget().setCursor(getState().cursorX, getState().cursorY);
        }
        if (stateChangeEvent.hasPropertyChanged("bgColor")) {
            getWidget().setBGColor(getState().bgColor);
        }
    }

    @Override
    protected void init() {
        super.init();
        getWidget().addMouseUpHandler(this);
    }

}
