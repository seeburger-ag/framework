/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class InputPromptAndCursorPositionTest extends MultiBrowserTest {

    @Test
    public void verifyDatePattern() {
        openTestURL();

        // Clear the current value and reveal the input prompt.
        TextFieldElement textFieldElement = $(TextFieldElement.class).get(0);
        textFieldElement.setValue("");

        // Update cursor position.
        $(ButtonElement.class).get(0).click();

        // The cursor position should now be zero (not the input prompt length).
        LabelElement cursorPosLabel = $(LabelElement.class).get(1);
        assertEquals(cursorPosLabel.getText(), "Cursor position: 0");
    }

}
