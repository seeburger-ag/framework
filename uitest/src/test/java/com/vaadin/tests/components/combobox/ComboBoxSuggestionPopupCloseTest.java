/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import static org.junit.Assert.assertFalse;
import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.ComboBoxElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * @author Vaadin Ltd
 */
public class ComboBoxSuggestionPopupCloseTest extends MultiBrowserTest {

    private WebElement selectTextbox;

    @Test
    public void closeSuggestionPopupTest() throws Exception {
        openTestURL();

        waitForElementVisible(By.className("v-filterselect"));

        selectTextbox = $(ComboBoxElement.class).first()
                .findElement(By.vaadin("#textbox"));
        selectTextbox.click();

        // open popup and select first element
        sendKeys(new Keys[] { ARROW_DOWN, ARROW_DOWN, ENTER });

        // open popup and hit enter to close it
        sendKeys(new Keys[] { ARROW_DOWN, ENTER });

        assertFalse(
                isElementPresent(By.className("v-filterselect-suggestmenu")));

    }

    private void sendKeys(Keys[] keys) throws Exception {
        for (Keys key : keys) {
            selectTextbox.sendKeys(key);
            // wait a while between the key presses, at least PhantomJS fails if
            // they are sent too fast
            sleep(10);
        }
    }
};
