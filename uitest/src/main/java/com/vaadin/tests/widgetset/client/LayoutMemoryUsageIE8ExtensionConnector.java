/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.vaadin.client.BrowserInfo;
import com.vaadin.client.LayoutManager;
import com.vaadin.client.LayoutManagerIE8;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.extensions.LayoutMemoryUsageIE8Extension;

@Connect(LayoutMemoryUsageIE8Extension.class)
public class LayoutMemoryUsageIE8ExtensionConnector
        extends AbstractExtensionConnector {

    @Override
    protected void extend(ServerConnector target) {
        if (BrowserInfo.get().isIE8()) {
            LayoutManagerIE8 manager = (LayoutManagerIE8) LayoutManager
                    .get(getConnection());
            configureGetMapSizeJS(manager);
        }
    }

    private native void configureGetMapSizeJS(LayoutManagerIE8 manager)
    /*-{
        $wnd.vaadin.getMeasuredSizesCount = function() {
            return manager.@com.vaadin.client.LayoutManagerIE8::getMeasuredSizesMapSize()();
        };
    }-*/;
}
