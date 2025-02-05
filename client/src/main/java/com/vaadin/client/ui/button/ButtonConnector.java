/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.button;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.StyleConstants;
import com.vaadin.client.VCaption;
import com.vaadin.client.WidgetUtil.ErrorUtil;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.ConnectorFocusAndBlurHandler;
import com.vaadin.client.ui.Icon;
import com.vaadin.client.ui.VButton;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.button.ButtonServerRpc;
import com.vaadin.shared.ui.button.ButtonState;
import com.vaadin.ui.Button;

@Connect(value = Button.class, loadStyle = LoadStyle.EAGER)
public class ButtonConnector extends AbstractComponentConnector
        implements ClickHandler {

    @Override
    public boolean delegateCaptionHandling() {
        return false;
    }

    @Override
    public void init() {
        super.init();
        getWidget().addClickHandler(this);
        getWidget().client = getConnection();
        ConnectorFocusAndBlurHandler.addHandlers(this);
    }

    @OnStateChange({"errorMessage", "errorLevel"})
    void setErrorMessageAndLevel() {
        if (null != getState().errorMessage) {
            if (getWidget().errorIndicatorElement == null) {
                getWidget().errorIndicatorElement = DOM.createSpan();
                getWidget().errorIndicatorElement.setClassName(
                        StyleConstants.STYLE_NAME_ERROR_INDICATOR);
            }

            ErrorUtil.setErrorLevelStyle(getWidget().errorIndicatorElement,
                    StyleConstants.STYLE_NAME_ERROR_INDICATOR,
                    getState().errorLevel);

            getWidget().wrapper.insertFirst(getWidget().errorIndicatorElement);

        } else if (getWidget().errorIndicatorElement != null) {
            getWidget().wrapper.removeChild(getWidget().errorIndicatorElement);
            getWidget().errorIndicatorElement = null;
        }
    }

    @OnStateChange("resources")
    void onResourceChange() {
        if (getWidget().icon != null) {
            getWidget().wrapper.removeChild(getWidget().icon.getElement());
            getWidget().icon = null;
        }
        Icon icon = getIcon();
        if (icon != null) {
            getWidget().icon = icon;
            icon.setAlternateText(getState().iconAltText);
            getWidget().wrapper.insertBefore(icon.getElement(),
                    getWidget().captionElement);
        }
    }

    @OnStateChange({ "caption", "captionAsHtml" })
    void setCaption() {
        VCaption.setCaptionText(getWidget().captionElement, getState());
    }

    @OnStateChange("iconAltText")
    void setIconAltText() {
        if (getWidget().icon != null) {
            getWidget().icon.setAlternateText(getState().iconAltText);
        }
    }

    @OnStateChange("clickShortcutKeyCode")
    void setClickShortcut() {
        getWidget().clickShortcut = getState().clickShortcutKeyCode;
    }

    @Override
    public VButton getWidget() {
        return (VButton) super.getWidget();
    }

    @Override
    public ButtonState getState() {
        return (ButtonState) super.getState();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (getState().disableOnClick) {
            // Simulate getting disabled from the server without waiting for the
            // round trip. The server-side RPC handler takes care of updating
            // the server-side state in a similar way to ensure subsequent
            // changes are properly propagated. Changing state on client is not
            // generally supported.
            getState().enabled = false;
            super.updateEnabledState(false);
            getRpcProxy(ButtonServerRpc.class).disableOnClick();
        }

        // Add mouse details
        MouseEventDetails details = MouseEventDetailsBuilder
                .buildMouseEventDetails(event.getNativeEvent(),
                        getWidget().getElement());
        getRpcProxy(ButtonServerRpc.class).click(details);

    }
}
