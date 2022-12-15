/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class SendMultibyteCharactersWebSocketTest
        extends SendMultibyteCharactersTest {

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        return getBrowsersSupportingWebSocket();
    }

    @Override
    protected String getTransport() {
        return "websocket";
    }
}
