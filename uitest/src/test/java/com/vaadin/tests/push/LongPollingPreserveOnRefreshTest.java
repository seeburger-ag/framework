/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class LongPollingPreserveOnRefreshTest extends MultiBrowserTest {

    private String buttonText;

    @Test
    public void testRefresh() {
        openTestURL();
        waitForElementPresent(By.className("v-button"));
        waitUntilButtonUpdated();

        // try several times because handling is timing-based
        for (int i = 0; i < 5; ++i) {
            refreshAndCheck();
        }
    }

    private void refreshAndCheck() {
        openTestURL();
        waitForElementPresent(By.className("v-button"));
        try {
            waitUntilLoadingIndicatorNotVisible();
        } catch (TimeoutException e) {
            fail("Page got stuck loading after refresh.");
        }

        // just in case the previous check passed before it got stuck
        waitUntilButtonUpdated();
    }

    private void waitUntilButtonUpdated() {
        buttonText = $(ButtonElement.class).first().getText();
        try {
            waitUntil(new ExpectedCondition<Object>() {
                @Override
                public Object apply(WebDriver driver) {
                    ButtonElement button = $(ButtonElement.class).first();
                    if (buttonText.isEmpty()) {
                        buttonText = button.getText();
                        return false;
                    }
                    return !buttonText.equals(button.getText());
                }
            });
        } catch (TimeoutException e) {
            fail("Button text didn't get updated, was: " + buttonText);
        } catch (StaleElementReferenceException e) {
            fail("Button reference got stale, text was: " + buttonText);
        }
    }
}
