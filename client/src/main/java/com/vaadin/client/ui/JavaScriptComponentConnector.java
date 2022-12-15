/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.vaadin.client.JavaScriptConnectorHelper;
import com.vaadin.client.communication.HasJavaScriptConnectorHelper;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.JavaScriptComponentState;
import com.vaadin.ui.AbstractJavaScriptComponent;

@Connect(AbstractJavaScriptComponent.class)
public final class JavaScriptComponentConnector extends
        AbstractComponentConnector implements HasJavaScriptConnectorHelper {

    private final JavaScriptConnectorHelper helper = new JavaScriptConnectorHelper(
            this) {
        @Override
        protected void showInitProblem(
                java.util.ArrayList<String> attemptedNames) {
            getWidget().showNoInitFound(attemptedNames);
        }
    };

    @Override
    public JavaScriptWidget getWidget() {
        return (JavaScriptWidget) super.getWidget();
    }

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
    public JavaScriptComponentState getState() {
        return (JavaScriptComponentState) super.getState();
    }

    @Override
    public void onUnregister() {
        super.onUnregister();
        helper.onUnregister();
    }
}
