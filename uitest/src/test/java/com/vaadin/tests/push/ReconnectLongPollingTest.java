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

public class ReconnectLongPollingTest extends ReconnectTest {

    @Override
    protected Class<?> getUIClass() {
        return BasicPushLongPolling.class;
    }

}
