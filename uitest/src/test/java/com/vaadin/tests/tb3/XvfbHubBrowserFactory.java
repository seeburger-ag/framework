/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tb3;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.parallel.Browser;
import com.vaadin.testbench.parallel.DefaultBrowserFactory;

public class XvfbHubBrowserFactory extends DefaultBrowserFactory {

    public DesiredCapabilities create(Browser browser) {
        switch (browser) {
        case IE11:
            return super.create(browser);
        case PHANTOMJS:
            return create(browser, "2", Platform.LINUX);
        case CHROME:
            return create(browser, "", Platform.ANY);
        case FIREFOX:
        default:
            return create(Browser.FIREFOX, "", Platform.ANY);
        }
    }
}
