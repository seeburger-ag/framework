/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PushConfigurationLongPollingTest extends PushConfigurationTest {

    @Test
    public void testLongPolling() throws InterruptedException {
        openDebugLogTab();

        getTransportSelect().selectByText("Long polling");
        assertThat(getStatusText(),
                containsString("fallbackTransport: long-polling"));
        assertThat(getStatusText(), containsString("transport: long-polling"));

        clearDebugMessages();
        getPushModeSelect().selectByText("Automatic");
        waitForDebugMessage("Push connection established using long-polling",
                10);
        waitForServerCounterToUpdate();
    }

}
