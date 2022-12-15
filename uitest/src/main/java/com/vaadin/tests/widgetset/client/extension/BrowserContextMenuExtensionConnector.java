/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.extension;

import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.contextclick.BrowserContextMenuInSubComponent.BrowserContextMenuExtension;

/**
 * Client-side connector of the {@link BrowserContextMenuExtension}.
 */
@Connect(BrowserContextMenuExtension.class)
public class BrowserContextMenuExtensionConnector
        extends AbstractExtensionConnector {

    @Override
    protected void extend(ServerConnector target) {
        getParent().getWidget().addDomHandler(new ContextMenuHandler() {

            @Override
            public void onContextMenu(ContextMenuEvent event) {
                // Stop context click events from propagating.
                event.stopPropagation();
            }
        }, ContextMenuEvent.getType());
    }

    @Override
    public AbstractComponentConnector getParent() {
        return (AbstractComponentConnector) super.getParent();
    }
}
