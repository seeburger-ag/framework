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
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.tests.tb3.newelements.ComboBoxElement;

public class ComboBoxPopupWhenBodyScrollsTest extends MultiBrowserTest {

    @Test
    public void popupBelow() {
        openTestURL();
        ComboBoxElement combobox = $(ComboBoxElement.class).first();
        combobox.openPopup();
        WebElement popup = $(ComboBoxElement.class).first()
                .getSuggestionPopup();

        int comboboxTop = combobox.getLocation().getY();
        int popupTop = popup.getLocation().getY();
        Assert.assertTrue("Popup should be below combobox",
                popupTop > comboboxTop);
    }
}
