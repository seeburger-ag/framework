/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.tests.tb3.newelements.ComboBoxElement;

public class ComboBoxCombinedWithEnterShortcutTest extends MultiBrowserTest {
    @Test
    public void testKeyboardSelection() throws InterruptedException {
        openTestURL();
        ComboBoxElement cb = $(ComboBoxElement.class).first();
        cb.click();
        cb.sendKeys(500, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER);
        Assert.assertEquals("", getLogRow(0).trim());
        cb.sendKeys(Keys.ENTER);
        Assert.assertEquals("1. Button clicked. ComboBox value: Berlin",
                getLogRow(0));
    }
}