/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.slider;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.client.ui.VSlider;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.slider.SliderServerRpc;
import com.vaadin.shared.ui.slider.SliderState;
import com.vaadin.ui.Slider;

@Connect(Slider.class)
public class SliderConnector extends AbstractFieldConnector
        implements ValueChangeHandler<Double> {

    protected SliderServerRpc rpc = RpcProxy.create(SliderServerRpc.class,
            this);

    private final ElementResizeListener resizeListener = new ElementResizeListener() {

        @Override
        public void onElementResize(ElementResizeEvent e) {
            getWidget().iLayout();
        }
    };

    @Override
    public void init() {
        super.init();
        getWidget().setConnection(getConnection());
        getWidget().addValueChangeHandler(this);

        getLayoutManager().addElementResizeListener(getWidget().getElement(),
                resizeListener);
    }

    @Override
    public void onUnregister() {
        super.onUnregister();
        getLayoutManager().removeElementResizeListener(getWidget().getElement(),
                resizeListener);
    }

    @Override
    public VSlider getWidget() {
        return (VSlider) super.getWidget();
    }

    @Override
    public SliderState getState() {
        return (SliderState) super.getState();
    }

    @Override
    public void onValueChange(ValueChangeEvent<Double> event) {
        getState().value = event.getValue();
        rpc.valueChanged(event.getValue());
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        getWidget().setId(getConnectorId());
        getWidget().setImmediate(getState().immediate);
        getWidget().setDisabled(!isEnabled());
        getWidget().setReadOnly(isReadOnly());
        getWidget().setOrientation(getState().orientation);
        getWidget().setMinValue(getState().minValue);
        getWidget().setMaxValue(getState().maxValue);
        getWidget().setResolution(getState().resolution);
        getWidget().setValue(getState().value, false);

        getWidget().buildBase();
        getWidget().setTabIndex(getState().tabIndex);
    }

}
