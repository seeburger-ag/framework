/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import java.io.IOException;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests that a TextField with 100% width fills the expanded column.
 *
 * @author Vaadin Ltd
 */
public class TextFieldRelativeWidthTest extends MultiBrowserTest {

    @Test
    public void testWidth() throws IOException {
        openTestURL();

        compareScreen("initial");

        ButtonElement button = $(ButtonElement.class).first();
        button.click();
        button.click();

        compareScreen("after");
    }

}
