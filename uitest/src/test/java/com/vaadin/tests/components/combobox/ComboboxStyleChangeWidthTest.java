/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.ComboBoxElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests that changing a stylename will not cause the width parameter to be
 * removed from a combobox.
 *
 * @author Vaadin Ltd
 */

public class ComboboxStyleChangeWidthTest extends MultiBrowserTest {

    @Test
    public void testWidthRetained() {
        openTestURL();

        ComboBoxElement comboBox = $(ComboBoxElement.class).first();
        String oldStyle = comboBox.getAttribute("style");

        ButtonElement button = $(ButtonElement.class).first();
        button.click();
        String newStyle = comboBox.getAttribute("style");

        assertEquals("width has changed, should remain equal", oldStyle,
                newStyle);

    }

}
