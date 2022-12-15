/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.datefield;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.VTextualDate;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.shared.ui.datefield.TextualDateFieldState;

public class TextualDateConnector extends AbstractDateFieldConnector {

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        Resolution origRes = getWidget().getCurrentResolution();
        String oldLocale = getWidget().getCurrentLocale();
        super.updateFromUIDL(uidl, client);
        if (origRes != getWidget().getCurrentResolution()
                || oldLocale != getWidget().getCurrentLocale()) {
            // force recreating format string
            getWidget().formatStr = null;
        }
        if (uidl.hasAttribute("format")) {
            getWidget().formatStr = uidl.getStringAttribute("format");
        }

        getWidget().inputPrompt = uidl
                .getStringAttribute(VTextualDate.ATTR_INPUTPROMPT);

        getWidget().lenient = !uidl.getBooleanAttribute("strict");

        getWidget().buildDate();
        // not a FocusWidget -> needs own tabindex handling
        getWidget().text.setTabIndex(getState().tabIndex);

        if (getWidget().isReadonly()) {
            getWidget().text.addStyleDependentName("readonly");
        } else {
            getWidget().text.removeStyleDependentName("readonly");
        }

    }

    @Override
    public VTextualDate getWidget() {
        return (VTextualDate) super.getWidget();
    }

    @Override
    public TextualDateFieldState getState() {
        return (TextualDateFieldState) super.getState();
    }
}
