/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.applicationcontext;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class RpcForClosedUITest extends MultiBrowserTest {
    @Override
    protected Class<?> getUIClass() {
        return CloseUI.class;
    }

    @Test
    public void testRpcForUIClosedInBackground() throws Exception {
        openTestURL();
        /* Close the UI in a background thread */
        clickButton("Close UI (background)");
        /* Try to log 'hello' */
        clickButton("Log 'hello'");
        /* Ensure 'hello' was not logged */
        checkLogMatches("2. Current WrappedSession id: .*");
        Assert.assertFalse("Page contains word 'Hello'",
                driver.getPageSource().contains("Hello"));
    }

    private void clickButton(String caption) {
        $(ButtonElement.class).caption(caption).first().click();
    }

    private void checkLogMatches(String expected) {
        String actual = getLogRow(0);
        Assert.assertTrue(String.format(
                "Unexpected log row.\n expected format: '%s'\n was: '%s'",
                expected, actual), actual.matches(expected));
    }
}
