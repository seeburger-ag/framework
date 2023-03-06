/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import com.vaadin.tests.tb3.SingleBrowserTest;
import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;

public class TimingInfoReportedTest extends SingleBrowserTest {

    @Test
    public void ensureTimingsAvailable() {
        openTestURL();
        Assert.assertEquals("2. Timings ok", getLogRow(0));
        $(ButtonElement.class).first().click();
        Assert.assertEquals("4. Timings ok", getLogRow(0));
    }
}
