/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import org.junit.Test;

public class BasicPushLongPollingTest extends BasicPushTest {

    @Test
    public void pushAfterServerTimeout() throws InterruptedException {
        getDriver().get(getTestUrl().replace("/run/", "/run-push-timeout/")
                + "?debug=push");
        sleep(11000); // Wait for server timeout (10s)

        getServerCounterStartButton().click();
        waitUntilServerCounterChanges();
    }

}
