/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.VOverlay;
import com.vaadin.client.WidgetUtil.ErrorUtil;
import com.vaadin.shared.ui.ErrorLevel;

public class VErrorMessage extends FlowPanel {
    public static final String CLASSNAME = "v-errormessage";

    private Widget owner;

    public VErrorMessage() {
        super();
        setStyleName(CLASSNAME);
    }

    /**
     * Set the owner, i.e the Widget that created this {@link VErrorMessage}.
     * The owner must be set if the {@link VErrorMessage} is created
     * 'stand-alone' (not within a {@link VOverlay}), or theming might not work
     * properly.
     *
     * @see VOverlay#setOwner(Widget)
     * @param owner
     *            the owner (creator Widget)
     */
    public void setOwner(Widget owner) {
        this.owner = owner;
    }

    public void updateMessage(String htmlErrorMessage) {
        clear();
        if (htmlErrorMessage == null || htmlErrorMessage.length() == 0) {
            add(new HTML(" "));
        } else {
            // pre-formatted on the server as div per child
            add(new HTML(htmlErrorMessage));
        }
    }

    /**
     * Sets the correct error level style name for the error message and removes
     * all previous style names.
     *
     * @param errorLevel
     *         error level
     * @since 7.7.11
     */
    public void updateErrorLevel(ErrorLevel errorLevel) {
        ErrorUtil.setErrorLevelStyle(getStyleElement(), CLASSNAME, errorLevel);
    }

    /**
     * Shows this error message next to given element.
     *
     * @param indicatorElement
     * @deprecated As of 7.2, call and override {@link #showAt(Element)} instead
     */
    @Deprecated
    public void showAt(com.google.gwt.user.client.Element indicatorElement) {
        VOverlay errorContainer = (VOverlay) getParent();
        if (errorContainer == null) {
            errorContainer = new VOverlay();
            errorContainer.setWidget(this);
            errorContainer.setOwner(owner);
        }
        errorContainer.setPopupPosition(
                DOM.getAbsoluteLeft(indicatorElement)
                        + 2 * DOM.getElementPropertyInt(indicatorElement,
                                "offsetHeight"),
                DOM.getAbsoluteTop(indicatorElement)
                        + 2 * DOM.getElementPropertyInt(indicatorElement,
                                "offsetHeight"));
        errorContainer.show();

    }

    /**
     * Shows this error message next to given element.
     *
     * @param indicatorElement
     *
     * @since 7.2
     */
    public void showAt(Element indicatorElement) {
        showAt(DOM.asOld(indicatorElement));
    }

    public void hide() {
        final VOverlay errorContainer = (VOverlay) getParent();
        if (errorContainer != null) {
            errorContainer.hide();
        }
    }
}
