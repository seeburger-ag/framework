/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.notification;

import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Test to check notification delay.
 *
 * @author Vaadin Ltd
 */
public class NotificationDelayTest extends MultiBrowserTest {

    @Test
    public void testDelay() throws InterruptedException {
        openTestURL();

        Assert.assertTrue("No notification found", hasNotification());

        waitUntil(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver input) {
                new Actions(getDriver()).moveByOffset(10, 10).perform();

                return !hasNotification();
            }
        });
    }

    private boolean hasNotification() {
        return isElementPresent(By.className("v-Notification"));
    }

}
