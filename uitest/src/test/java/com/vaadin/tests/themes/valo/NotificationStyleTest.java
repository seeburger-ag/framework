/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Test for H1 and P elements styles in Notifications.
 *
 * @author Vaadin Ltd
 */
public class NotificationStyleTest extends MultiBrowserTest {

    @Test
    public void testNotificationH1Style() {
        openTestURL();

        $(ButtonElement.class).first().click();

        new Actions(getDriver()).moveByOffset(10, 10).perform();
        waitUntil(notificationPresentCondition(), 2);

        WebElement notification = findElement(By.className("v-Notification"));
        List<WebElement> headers = notification
                .findElements(By.tagName(ValoTheme.LABEL_H1));
        String textAlign = headers.get(0).getCssValue("text-align");
        String textAlignInnerHeader = headers.get(1).getCssValue("text-align");
        Assert.assertNotEquals(
                "Styles for notification defined h1 tag "
                        + "and custom HTML tag are the same",
                textAlign, textAlignInnerHeader);
    }

    @Test
    public void testNotificationPStyle() {
        openTestURL();

        $(ButtonElement.class).get(1).click();

        new Actions(getDriver()).moveByOffset(10, 10).perform();
        waitUntil(notificationPresentCondition(), 2);

        WebElement notification = findElement(By.className("v-Notification"));
        WebElement description = notification
                .findElement(By.className("v-Notification-description"));
        String display = description.getCssValue("display");
        String displayP2 = notification.findElement(By.className("tested-p"))
                .getCssValue("display");
        Assert.assertNotEquals(
                "Styles for notification defined 'p' tag "
                        + "and custom HTML tag are the same",
                display, displayP2);
    }

    private ExpectedCondition<Boolean> notificationPresentCondition() {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver input) {
                return isElementPresent(By.className("v-Notification"));
            }
        };
    }
}
