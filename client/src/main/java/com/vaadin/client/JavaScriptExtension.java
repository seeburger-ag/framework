/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client;

import com.vaadin.client.communication.HasJavaScriptConnectorHelper;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.shared.JavaScriptExtensionState;
import com.vaadin.shared.ui.Connect;

@Connect(AbstractJavaScriptExtension.class)
public final class JavaScriptExtension extends AbstractExtensionConnector
        implements HasJavaScriptConnectorHelper {
    private final JavaScriptConnectorHelper helper = new JavaScriptConnectorHelper(
            this);

    @Override
    protected void init() {
        super.init();
        helper.init();
    }

    @Override
    public JavaScriptConnectorHelper getJavascriptConnectorHelper() {
        return helper;
    }

    @Override
    public JavaScriptExtensionState getState() {
        return (JavaScriptExtensionState) super.getState();
    }

    @Override
    public void onUnregister() {
        super.onUnregister();
        helper.onUnregister();
    }

    @Override
    protected void extend(ServerConnector target) {
        // Nothing to do for JavaScriptExtension here. Everything is done in
        // javascript.
    }
}
