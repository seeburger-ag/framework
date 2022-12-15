/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class PollListeningTest extends MultiBrowserTest {

    @Test
    public void testReceivePollEvent() {
        openTestURL();
        waitUntilPollEventReceived();
    }

    private void waitUntilPollEventReceived() {
        waitUntil(new ExpectedCondition<Boolean>() {
            private String expected = "PollEvent received";

            @Override
            public Boolean apply(WebDriver arg0) {
                return driver.getPageSource().contains(expected);
            }

            @Override
            public String toString() {
                return String.format("page to contain text '%s'", expected);
            }
        });
    }
}
