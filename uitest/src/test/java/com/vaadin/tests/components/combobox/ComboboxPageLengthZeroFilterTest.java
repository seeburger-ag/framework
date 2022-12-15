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

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.ComboBoxElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class ComboboxPageLengthZeroFilterTest extends MultiBrowserTest {

    @Test
    public void testOptionsNotEmpty() {
        openTestURL();

        List<String> suggestions = getFilterSuggestions("T");

        Assert.assertEquals("All items should be presented!", 12,
                suggestions.size());
    }

    private List<String> getFilterSuggestions(String string) {
        ComboBoxElement comboBox = $(ComboBoxElement.class).first();
        comboBox.findElement(By.vaadin("#textbox")).sendKeys(string);
        return comboBox.getPopupSuggestions();
    }
}
