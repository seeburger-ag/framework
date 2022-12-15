/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class WindowZIndexTest extends MultiBrowserTest {

    @Test
    public void removingUpdatesZIndices() throws IOException {
        openTestURL();

        WebElement addButton = driver
                .findElement(By.xpath("//span[contains(text(),'Add window')]"));
        WebElement closeButton = driver.findElement(
                By.xpath("//span[contains(text(),'Close window')]"));

        addButton.click();
        addButton.click();
        addButton.click();
        addButton.click();
        addButton.click();

        closeButton.click();
        closeButton.click();
        closeButton.click();

        addButton.click();
        addButton.click();
        addButton.click();
        addButton.click();

        compareScreen("stacked");

        WebElement window4 = driver
                .findElement(By.xpath("//*[contains(text(), 'Window 4')]"));
        new Actions(driver).moveToElement(window4, getXOffset(window4, 1), getYOffset(window4, 9)).click().perform();

        compareScreen("win4-on-top");
    }
}
