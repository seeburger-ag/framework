/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.google.gwt.user.client.ui.HTML;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.PostLayoutListener;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.LayoutDetector;

@Connect(LayoutDetector.class)
public class LayoutDetectorConnector extends AbstractComponentConnector
        implements PostLayoutListener {
    private int layoutCount = 0;
    private int rpcCount = 0;

    @Override
    protected void init() {
        super.init();
        updateText();

        registerRpc(NoLayoutRpc.class, new NoLayoutRpc() {
            @Override
            public void doRpc() {
                rpcCount++;
                updateText();
            }
        });
    }

    @Override
    public HTML getWidget() {
        return (HTML) super.getWidget();
    }

    @Override
    public void postLayout() {
        layoutCount++;
        updateText();
    }

    private void updateText() {
        getWidget().setHTML("Layout count: <span id='layoutCount'>"
                + layoutCount + "</span><br />RPC count: <span id='rpcCount'>"
                + rpcCount + "</span>");
    }
}
