/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elementsbase.ServerClass;
import com.vaadin.tests.tb3.newelements.ComboBoxElement;

@ServerClass("com.vaadin.ui.ComboBox")
public class CustomComboBoxElement extends ComboBoxElement {
    private static org.openqa.selenium.By bySuggestionPopup = By
            .vaadin("#popup");

    @Override
    public WebElement getSuggestionPopup() {
        ensurePopupOpen();
        return findElement(bySuggestionPopup);
    }

    private void ensurePopupOpen() {
        if (!isElementPresent(bySuggestionPopup)) {
            openPopup();
        }
    }

}
