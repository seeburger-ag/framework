/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.helloworldfeature;

import com.vaadin.shared.communication.ServerRpc;

public interface HelloWorldRpc extends ServerRpc {
    public void onMessageSent(String message);
}
