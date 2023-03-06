/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class TabSheetFocusingTest extends MultiBrowserTest {

    @Test
    public void addAndFocusTabs() throws IOException {
        openTestURL();
        WebElement addButton = getButton("Add tab");
        for (int i = 1; i <= 15; i++) {
            addButton.click();
            getButton("Tab " + i);
        }
        compareScreen("tabsAdded");
    }

    private WebElement getButton(String caption) {
        return driver.findElement(By.xpath(
                "//span[@class='v-button-caption'][text()='" + caption + "']"));
    }
}
