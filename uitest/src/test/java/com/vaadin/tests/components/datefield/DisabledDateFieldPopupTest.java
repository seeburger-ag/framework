/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class DisabledDateFieldPopupTest extends MultiBrowserTest {

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        return getIEBrowsersOnly();
    }

    @Test
    public void testPopup() throws IOException {
        openTestURL();

        WebElement button = driver
                .findElement(By.className("v-datefield-button"));
        new Actions(driver).moveToElement(button).click()
                .sendKeys(Keys.ARROW_DOWN).perform();

        Assert.assertFalse(
                "Calendar popup should not be opened for disabled date field",
                isElementPresent(By.className("v-datefield-popup")));
    }
}
