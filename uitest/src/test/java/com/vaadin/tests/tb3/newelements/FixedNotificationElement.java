/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tb3.newelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.NotificationElement;
import com.vaadin.testbench.elementsbase.ServerClass;

@ServerClass("com.vaadin.ui.Notification")
public class FixedNotificationElement extends NotificationElement {
    @Override
    public String getCaption() {
        WebElement popup = findElement(By.className("popupContent"));
        WebElement caption = popup.findElement(By.tagName("h1"));
        return caption.getText();
    }

    @Override
    public void close() {
        click(5, 5);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions
                .not(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.className("v-Notification"))));
    }
}
