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

import com.vaadin.tests.tb3.MultiBrowserTest;

public class InitiallyEmptyFragmentTest extends MultiBrowserTest {

    @Override
    protected Class<?> getUIClass() {
        return InitialFragmentEvent.class;
    }

    @Test
    public void testNoFragmentChangeEventWhenInitiallyEmpty() throws Exception {
        openTestURL();
        /*
         * There is no fragment change event when the fragment is initially
         * empty
         */
        assertLogText(" ");
        executeScript("window.location.hash='bar'");
        assertLogText("1. Fragment changed from \"no event received\" to bar");
    }

    private void assertLogText(String expected) {
        Assert.assertEquals("Unexpected log contents,", expected, getLogRow(0));
    }
}
