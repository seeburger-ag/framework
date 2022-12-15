/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class ResynchronizeAfterAsyncRemovalTest extends SingleBrowserTest {
    @Test
    public void noResyncAfterAsyncRemoval() {
        openTestURL();

        $(ButtonElement.class).first().click();

        Assert.assertEquals("Timing issue in the test?",
                "1. Window removed: true", getLogRow(1));

        Assert.assertEquals(
                "Removing window should not cause button to be marked as dirty",
                "2. Dirty: false", getLogRow(0));
    }
}
