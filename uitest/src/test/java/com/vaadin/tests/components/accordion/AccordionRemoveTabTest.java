/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.accordion;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for Accordion: tabs should stay selectable after remove tab.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class AccordionRemoveTabTest extends MultiBrowserTest {

    @Test
    public void testRemoveTab() {
        openTestURL();

        WebElement button = driver.findElement(By.className("v-button"));
        button.click();

        checkFirstItemHeight("On second tab");

        button.click();

        checkFirstItemHeight("On third tab");
    }

    @Test
    public void testConsoleErrorOnSwitch() {
        setDebug(true);
        openTestURL();
        WebElement firstItem = driver
                .findElement(By.className("v-accordion-item-first"));
        WebElement caption = firstItem
                .findElement(By.className("v-accordion-item-caption"));
        caption.click();
        Assert.assertEquals("Errors present in console", 0,
                findElements(By.className("SEVERE")).size());
    }

    private void checkFirstItemHeight(String text) {
        WebElement firstItem = driver
                .findElement(By.className("v-accordion-item-first"));
        WebElement label = firstItem.findElement(By.className("v-label"));
        Assert.assertEquals("Unexpected text in first item", text,
                label.getText());
        int height = firstItem.getSize().getHeight();
        WebElement accordion = driver.findElement(By.className("v-accordion"));
        Assert.assertTrue("First item in accordion has unexpected height",
                height > accordion.getSize().getHeight() / 2);
    }

}
