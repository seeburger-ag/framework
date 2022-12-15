/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.parallel.Browser;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class WindowBGColorChameleonIE8Test extends SingleBrowserTest {

    /*
     * We care about IE8 here only (Or any very very old browsers)
     *
     * @see com.vaadin.tests.tb3.SingleBrowserTest#getBrowsersToTest()
     */
    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        return Arrays.asList(Browser.IE8.getDesiredCapabilities());
    }

    @Test
    public void testWindowColor() throws IOException {
        openTestURL();
        compareScreen("grey-background-window");
    }
}
