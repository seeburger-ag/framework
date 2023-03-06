/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.link;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.DOM;
import com.vaadin.client.StyleConstants;
import com.vaadin.client.VCaption;
import com.vaadin.client.WidgetUtil.ErrorUtil;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.Icon;
import com.vaadin.client.ui.VLink;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.link.LinkConstants;
import com.vaadin.shared.ui.link.LinkState;
import com.vaadin.ui.Link;

@Connect(Link.class)
public class LinkConnector extends AbstractComponentConnector {

    @Override
    public LinkState getState() {
        return (LinkState) super.getState();
    }

    @Override
    public boolean delegateCaptionHandling() {
        return false;
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        getWidget().enabled = isEnabled();

        if (stateChangeEvent.hasPropertyChanged("resources")) {
            getWidget().src = getResourceUrl(LinkConstants.HREF_RESOURCE);
            if (getWidget().src == null) {
                getWidget().anchor.removeAttribute("href");
            } else {
                getWidget().anchor.setAttribute("href", getWidget().src);
            }
        }

        getWidget().target = getState().target;
        if (getWidget().target == null) {
            getWidget().anchor.removeAttribute("target");
        } else {
            getWidget().anchor.setAttribute("target", getWidget().target);
        }

        getWidget().borderStyle = getState().targetBorder;
        getWidget().targetWidth = getState().targetWidth;
        getWidget().targetHeight = getState().targetHeight;

        // Set link caption
        VCaption.setCaptionText(getWidget().captionElement, getState());

        // handle error
        if (null != getState().errorMessage) {
            if (getWidget().errorIndicatorElement == null) {
                getWidget().errorIndicatorElement = DOM.createDiv();
                DOM.setElementProperty(getWidget().errorIndicatorElement,
                        "className", StyleConstants.STYLE_NAME_ERROR_INDICATOR);
            }

            ErrorUtil.setErrorLevelStyle(getWidget().errorIndicatorElement,
                    StyleConstants.STYLE_NAME_ERROR_INDICATOR,
                    getState().errorLevel);

            DOM.insertChild(getWidget().getElement(),
                    getWidget().errorIndicatorElement, 0);
        } else if (getWidget().errorIndicatorElement != null) {
            getWidget().errorIndicatorElement.getStyle()
                    .setDisplay(Display.NONE);
        }

        if (getWidget().icon != null) {
            getWidget().anchor.removeChild(getWidget().icon.getElement());
            getWidget().icon = null;
        }
        Icon icon = getIcon();
        if (icon != null) {
            getWidget().icon = icon;
            getWidget().anchor.insertBefore(icon.getElement(),
                    getWidget().captionElement);
        }
    }

    @Override
    public VLink getWidget() {
        return (VLink) super.getWidget();
    }
}
