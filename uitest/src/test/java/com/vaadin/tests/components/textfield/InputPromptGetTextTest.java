/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class InputPromptGetTextTest extends MultiBrowserTest {

    @Test
    public void test() {
        openTestURL();

        WebElement field = getDriver()
                .findElement(By.id(InputPromptGetText.FIELD));

        WebElement button = getDriver()
                .findElement(By.id(InputPromptGetText.BUTTON));

        String string = getRandomString();
        field.sendKeys(string + "\n");

        String selectAll = Keys.chord(Keys.CONTROL, "a");
        field.sendKeys(selectAll);
        field.sendKeys(Keys.BACK_SPACE);

        button.click();

        WebElement label = getDriver()
                .findElement(By.id(InputPromptGetText.LABEL2));

        Assert.assertEquals("Your input was:", label.getText().trim());
    }

    private String getRandomString() {
        String string = RandomStringUtils.randomAlphanumeric(3);
        return string;
    }

}
