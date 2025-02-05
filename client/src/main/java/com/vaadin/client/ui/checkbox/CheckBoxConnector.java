/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.checkbox;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.StyleConstants;
import com.vaadin.client.VCaption;
import com.vaadin.client.VTooltip;
import com.vaadin.client.WidgetUtil.ErrorUtil;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.client.ui.ConnectorFocusAndBlurHandler;
import com.vaadin.client.ui.Icon;
import com.vaadin.client.ui.VCheckBox;
import com.vaadin.shared.EventId;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.checkbox.CheckBoxServerRpc;
import com.vaadin.shared.ui.checkbox.CheckBoxState;
import com.vaadin.ui.CheckBox;

@Connect(CheckBox.class)
public class CheckBoxConnector extends AbstractFieldConnector
        implements ClickHandler {

    @Override
    public boolean delegateCaptionHandling() {
        return false;
    }

    @Override
    protected void init() {
        super.init();

        getWidget().addClickHandler(this);
        getWidget().client = getConnection();
        getWidget().id = getConnectorId();

        ConnectorFocusAndBlurHandler.addHandlers(this);
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        if (null != getState().errorMessage) {
            getWidget().setAriaInvalid(true);

            if (getWidget().errorIndicatorElement == null) {
                getWidget().errorIndicatorElement = DOM.createSpan();
                getWidget().errorIndicatorElement.setInnerHTML("&nbsp;");
                DOM.setElementProperty(getWidget().errorIndicatorElement,
                        "className", StyleConstants.STYLE_NAME_ERROR_INDICATOR);
                DOM.appendChild(getWidget().getElement(),
                        getWidget().errorIndicatorElement);
                DOM.sinkEvents(getWidget().errorIndicatorElement,
                        VTooltip.TOOLTIP_EVENTS | Event.ONCLICK);
            } else {
                getWidget().errorIndicatorElement.getStyle().clearDisplay();
            }

            ErrorUtil.setErrorLevelStyle(getWidget().errorIndicatorElement,
                    StyleConstants.STYLE_NAME_ERROR_INDICATOR,
                    getState().errorLevel);

        } else if (getWidget().errorIndicatorElement != null) {
            getWidget().errorIndicatorElement.getStyle()
                    .setDisplay(Display.NONE);

            getWidget().setAriaInvalid(false);
        }

        getWidget().setAriaRequired(isRequired());
        if (isReadOnly()) {
            getWidget().setEnabled(false);
        }

        if (getWidget().icon != null) {
            getWidget().getElement().removeChild(getWidget().icon.getElement());
            getWidget().icon = null;
        }
        Icon icon = getIcon();
        if (icon != null) {
            getWidget().icon = icon;
            DOM.insertChild(getWidget().getElement(), icon.getElement(), 1);
            icon.sinkEvents(VTooltip.TOOLTIP_EVENTS);
            icon.sinkEvents(Event.ONCLICK);
        }

        // Set text
        VCaption.setCaptionText(getWidget(), getState());

        getWidget().setValue(getState().checked);
        getWidget().immediate = getState().immediate;
    }

    @Override
    public CheckBoxState getState() {
        return (CheckBoxState) super.getState();
    }

    @Override
    public VCheckBox getWidget() {
        return (VCheckBox) super.getWidget();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (!isEnabled()) {
            return;
        }

        // We get click events also from the label text, which do not alter the
        // actual value. The server-side is only interested in real changes to
        // the state.
        if (getState().checked != getWidget().getValue()) {
            getState().checked = getWidget().getValue();

            // Add mouse details
            MouseEventDetails details = MouseEventDetailsBuilder
                    .buildMouseEventDetails(event.getNativeEvent(),
                            getWidget().getElement());
            getRpcProxy(CheckBoxServerRpc.class).setChecked(getState().checked,
                    details);
            if (getState().immediate) {
                getConnection().sendPendingVariableChanges();
            }
        }
    }

    private boolean contextEventSunk = false;

    @OnStateChange("registeredEventListeners")
    void sinkContextClickEvent() {
        if (!contextEventSunk && hasEventListener(EventId.CONTEXT_CLICK)) {
            // CheckBox.sinkEvents works differently than all other widgets:
            // "Unlike other widgets the CheckBox sinks on its inputElement, not
            // its wrapper"
            DOM.sinkEvents(getWidget().getElement(), Event.ONCONTEXTMENU);
            contextEventSunk = true;
        }
    }
}
