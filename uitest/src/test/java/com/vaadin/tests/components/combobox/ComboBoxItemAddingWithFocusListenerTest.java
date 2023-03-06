/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.vaadin.testbench.By;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.tests.tb3.newelements.ComboBoxElement;

public class ComboBoxItemAddingWithFocusListenerTest extends MultiBrowserTest {

    @Test
    public void testPopupViewContainsAddedItem() {
        openTestURL();
        ComboBoxElement cBox = $(ComboBoxElement.class).first();
        ButtonElement focusTarget = $(ButtonElement.class).first();
        cBox.openPopup();
        int i = 0;
        while (i < 3) {
            assertTrue("No item added on focus",
                    cBox.getPopupSuggestions().contains("Focus" + i++));
            focusTarget.focus();
            ((TestBenchElement) cBox.findElement(By.vaadin("#textbox")))
                    .focus();
        }
        assertTrue("No item added on focus",
                cBox.getPopupSuggestions().contains("Focus" + i));
    }
}
