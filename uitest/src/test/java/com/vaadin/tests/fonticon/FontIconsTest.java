/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.fonticon;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.Keys;

import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.tests.tb3.newelements.ComboBoxElement;

public class FontIconsTest extends MultiBrowserTest {

    @Test
    public void checkScreenshot() throws IOException {
        openTestURL();
        compareScreen("all");
    }

    @Test
    public void comboBoxItemIconsOnKeyboardNavigation() throws Exception {
        openTestURL();

        ComboBoxElement comboBox = $(ComboBoxElement.class).first();

        // No initial value.
        assertEquals("", comboBox.getText());

        // Navigate to the first item with keyboard navigation.
        comboBox.sendKeys(400, Keys.ARROW_DOWN, Keys.ARROW_DOWN);

        // Value must be "One" without any extra characters.
        // See ticket #14660
        assertEquals("One", comboBox.getText());

        // Check also the second item.
        comboBox.sendKeys(Keys.ARROW_DOWN);
        assertEquals("Two", comboBox.getText());
    }
}
