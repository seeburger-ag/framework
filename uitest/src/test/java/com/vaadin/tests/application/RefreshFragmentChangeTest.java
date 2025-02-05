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

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class RefreshFragmentChangeTest extends MultiBrowserTest {
    @Override
    protected Class<?> getUIClass() {
        return com.vaadin.tests.application.RefreshStatePreserve.class;
    }

    @Test
    public void testFragmentChange() throws Exception {
        openTestURL();
        assertLogText("1. Initial fragment: null");
        getDriver().get(getTestUrl() + "#asdf");
        assertLogText("2. Fragment changed to asdf");
        openTestURL();
        assertLogText("3. Fragment changed to null");
    }

    private void assertLogText(String expected) {
        waitForElementPresent(By.className("v-label"));
        Assert.assertEquals("Incorrect log text,", expected, getLogRow(0));
    }
}
