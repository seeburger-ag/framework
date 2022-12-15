/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class VerifyAssertionsEnabledTest extends SingleBrowserTest {
    @Test
    public void verifyServerAssertions() throws Exception {
        openTestURL();
        Assert.assertEquals("1. Assertions are enabled", getLogRow(0));
    }
}
