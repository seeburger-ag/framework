/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.nativebutton;

import com.google.gwt.user.client.DOM;
import com.vaadin.client.StyleConstants;
import com.vaadin.client.VCaption;
import com.vaadin.client.WidgetUtil.ErrorUtil;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.ConnectorFocusAndBlurHandler;
import com.vaadin.client.ui.Icon;
import com.vaadin.client.ui.VNativeButton;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.button.ButtonServerRpc;
import com.vaadin.shared.ui.button.NativeButtonState;
import com.vaadin.ui.NativeButton;

@Connect(NativeButton.class)
public class NativeButtonConnector extends AbstractComponentConnector {

    @Override
    public void init() {
        super.init();

        getWidget().buttonRpcProxy = getRpcProxy(ButtonServerRpc.class);
        getWidget().client = getConnection();
        getWidget().paintableId = getConnectorId();

        ConnectorFocusAndBlurHandler.addHandlers(this);
    }

    @Override
    public boolean delegateCaptionHandling() {
        return false;
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        getWidget().disableOnClick = getState().disableOnClick;

        // Set text
        VCaption.setCaptionText(getWidget(), getState());

        // handle error
        if (null != getState().errorMessage) {
            if (getWidget().errorIndicatorElement == null) {
                getWidget().errorIndicatorElement = DOM.createSpan();
                getWidget().errorIndicatorElement.setClassName(
                        StyleConstants.STYLE_NAME_ERROR_INDICATOR);
            }

            ErrorUtil.setErrorLevelStyle(getWidget().errorIndicatorElement,
                    StyleConstants.STYLE_NAME_ERROR_INDICATOR,
                    getState().errorLevel);

            getWidget().getElement().insertBefore(
                    getWidget().errorIndicatorElement,
                    getWidget().captionElement);

        } else if (getWidget().errorIndicatorElement != null) {
            getWidget().getElement()
                    .removeChild(getWidget().errorIndicatorElement);
            getWidget().errorIndicatorElement = null;
        }

        if (getWidget().icon != null) {
            getWidget().getElement().removeChild(getWidget().icon.getElement());
            getWidget().icon = null;
        }
        Icon icon = getIcon();
        if (icon != null) {
            getWidget().icon = icon;
            getWidget().getElement().insertBefore(icon.getElement(),
                    getWidget().captionElement);
            icon.setAlternateText(getState().iconAltText);
        }

    }

    @Override
    public VNativeButton getWidget() {
        return (VNativeButton) super.getWidget();
    }

    @Override
    public NativeButtonState getState() {
        return (NativeButtonState) super.getState();
    }
}
