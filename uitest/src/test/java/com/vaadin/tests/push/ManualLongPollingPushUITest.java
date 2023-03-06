/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class ManualLongPollingPushUITest extends SingleBrowserTest {

    @Test
    public void doubleManualPushDoesNotFreezeApplication() {
        openTestURL();
        $(ButtonElement.class).caption("Double manual push after 1s").first()
                .click();
        waitUntilLogText(
                "2. Second message logged after 1s, followed by manual push");
        $(ButtonElement.class).caption("Manual push after 1s").first().click();
        waitUntilLogText("3. Logged after 1s, followed by manual push");
    }

    private void waitUntilLogText(final String expected) {
        waitUntil(new ExpectedCondition<Boolean>() {
            private String actual;

            @Override
            public Boolean apply(WebDriver arg0) {
                actual = getLogRow(0);
                return expected.equals(actual);
            }

            @Override
            public String toString() {
                return String.format("log text to become '%s' (was: '%s')",
                        expected, actual);
            }
        });
    }
}
