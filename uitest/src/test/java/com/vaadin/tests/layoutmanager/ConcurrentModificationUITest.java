/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layoutmanager;

import org.junit.Test;

import com.vaadin.tests.tb3.SingleBrowserTest;
import org.openqa.selenium.Dimension;

public class ConcurrentModificationUITest extends SingleBrowserTest {

    @Test
    public void noExceptionWhenEnlarging() {
        getDriver().manage().window().setSize(new Dimension(100, 100));
        openTestURL("debug");
        getDriver().manage().window().setSize(new Dimension(200, 200));
        assertNoErrorNotifications();
    }
}
