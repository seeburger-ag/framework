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
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.VColorPicker;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.colorpicker.ColorPickerServerRpc;
import com.vaadin.ui.ColorPicker;

/**
 * A class that defines default implementation for a color picker connector.
 * Connects the server side {@link ColorPicker} with the client side counterpart
 * {@link VColorPicker}
 *
 * @since 7.0.0
 */
@Connect(value = ColorPicker.class, loadStyle = LoadStyle.LAZY)
public class ColorPickerConnector extends AbstractColorPickerConnector {

    private ColorPickerServerRpc rpc = RpcProxy
            .create(ColorPickerServerRpc.class, this);

    @Override
    protected Widget createWidget() {
        return GWT.create(VColorPicker.class);
    }

    @Override
    public VColorPicker getWidget() {
        return (VColorPicker) super.getWidget();
    }

    @Override
    public void onClick(ClickEvent event) {
        rpc.openPopup(getWidget().isOpen());
    }

    @Override
    protected void setCaption(String caption) {
        if (getState().captionAsHtml) {
            getWidget().setHtml(caption);
        } else {
            getWidget().setText(caption);
        }
    }

    @Override
    protected void refreshColor() {
        getWidget().refreshColor();
    }
}
