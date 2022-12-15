/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import com.vaadin.tests.widgetset.client.NoLayoutRpc;
import com.vaadin.ui.AbstractComponent;

public class LayoutDetector extends AbstractComponent {

    public void doNoLayoutRpc() {
        getRpcProxy(NoLayoutRpc.class).doRpc();
    }
}
