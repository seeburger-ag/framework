/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class UIInitExceptionTest extends SingleBrowserTest {
    @Test
    public void testExceptionOnUIInit() throws Exception {
        openTestURL();
        Assert.assertTrue("Page does not contain the given text",
                driver.getPageSource().contains("Catch me if you can"));
    }
}
