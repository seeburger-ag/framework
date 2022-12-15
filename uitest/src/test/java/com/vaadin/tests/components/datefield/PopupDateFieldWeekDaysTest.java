/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.CheckBoxElement;
import com.vaadin.testbench.elements.PopupDateFieldElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class PopupDateFieldWeekDaysTest extends SingleBrowserTest {

    @Test
    public void testFiLocale_weekNumbersVisible() {
        openTestURL();

        openPopupAndValidateWeekNumbers();
    }

    @Test
    public void testToggleWeekNumbers_renderedCorrectly() {
        openTestURL();

        openPopupAndValidateWeekNumbers();

        $(CheckBoxElement.class).first().click();

        Assert.assertFalse(
                "Checkbox is selected even though should be unselected.",
                $(CheckBoxElement.class).first().getValue().equals("true"));

        openPopupAndValidateNoWeeknumbers();
    }

    @Test
    public void testLocaleChangeToEnglish_removesWeekNumbers() {
        openTestURL();

        openPopupAndValidateWeekNumbers();

        $(ButtonElement.class).id("english").click();

        openPopupAndValidateNoWeeknumbers();
    }

    @Test
    public void testChangeBackToFinnish_weekNumbersVisible() {
        openTestURL();

        $(ButtonElement.class).id("english").click();

        openPopupAndValidateNoWeeknumbers();

        $(ButtonElement.class).id("finnish").click();

        openPopupAndValidateWeekNumbers();
    }

    private void openPopupAndValidateWeekNumbers() {
        WebElement popupButton = $(PopupDateFieldElement.class).first()
                .findElement(By.className("v-datefield-button"));
        // Open date popup
        popupButton.click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("v-datefield-popup")));

        Assert.assertFalse("No week numbers found for date field!",
                findElements(
                        By.className("v-datefield-calendarpanel-weeknumber"))
                                .isEmpty());
        // Close popup
        popupButton.click();
    }

    private void openPopupAndValidateNoWeeknumbers() {
        WebElement popupButton = $(PopupDateFieldElement.class).first()
                .findElement(By.className("v-datefield-button"));
        // Open date popup
        popupButton.click();

        waitUntil(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("v-datefield-popup")));

        Assert.assertTrue("Week numbers still found in calendar popup!",
                findElements(
                        By.className("v-datefield-calendarpanel-weeknumber"))
                                .isEmpty());
        // Close popup
        popupButton.click();
    }
}
