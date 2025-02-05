/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.SingleBrowserTest;
import com.vaadin.tests.tb3.newelements.ComboBoxElement;

public class ComboBoxItemStyleGeneratorTest extends SingleBrowserTest {
    @Test
    public void testItemStyleGenerator() {
        openTestURL();

        ComboBoxElement comboBox = $(ComboBoxElement.class).first();

        selectMenuPath("Component", "Features", "Item style generator",
                "Bold fives");

        comboBox.openPopup();

        List<WebElement> boldItems = findElements(
                By.className("v-filterselect-item-bold"));

        Assert.assertEquals(1, boldItems.size());
        Assert.assertEquals("Item 5", boldItems.get(0).getText());

        selectMenuPath("Component", "Features", "Item style generator", "-");

        boldItems = findElements(By.className("v-filterselect-item-bold"));
        Assert.assertEquals(0, boldItems.size());
    }

    @Override
    protected Class<?> getUIClass() {
        return ComboBoxes2.class;
    }

}
