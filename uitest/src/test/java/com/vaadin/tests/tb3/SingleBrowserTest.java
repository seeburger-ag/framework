/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tb3;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.parallel.Browser;

public abstract class SingleBrowserTest extends PrivateTB3Configuration {
    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        if (isRunLocally()) {
            return Collections.singletonList(getRunLocallyCapabilities());
        }
        return Collections
                .singletonList(Browser.CHROME.getDesiredCapabilities());
    }
}
