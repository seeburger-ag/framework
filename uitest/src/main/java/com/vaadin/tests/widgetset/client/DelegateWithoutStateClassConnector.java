/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client;

import com.google.gwt.core.shared.GWT;
import com.vaadin.client.ui.textarea.TextAreaConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.DelegateWithoutStateClassComponent;

@Connect(DelegateWithoutStateClassComponent.class)
public class DelegateWithoutStateClassConnector extends TextAreaConnector {
    @Override
    public VExtendedTextArea getWidget() {
        return (VExtendedTextArea) super.getWidget();
    }

    @Override
    protected VExtendedTextArea createWidget() {
        return GWT.create(VExtendedTextArea.class);
    }
}
