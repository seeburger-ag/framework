/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import com.google.gwt.core.client.RunAsyncCallback;

/**
 * A helper class used by WidgetMap implementation. Used by the generated code.
 */
abstract class WidgetLoader implements RunAsyncCallback {

    @Override
    public void onFailure(Throwable reason) {
        ApplicationConfiguration.endDependencyLoading();
    }

    @Override
    public void onSuccess() {
        addInstantiator();
        ApplicationConfiguration.endDependencyLoading();
    }

    abstract void addInstantiator();
}
