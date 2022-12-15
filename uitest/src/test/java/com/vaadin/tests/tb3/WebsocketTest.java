/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.tests.tb3;

import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.parallel.TestCategory;

/**
 * A {@link MultiBrowserTest} which restricts the tests to the browsers which
 * support websocket
 *
 * @author Vaadin Ltd
 */
@TestCategory("push")
public abstract class WebsocketTest extends MultiBrowserTest {

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        return getBrowsersSupportingWebSocket();
    }
}
