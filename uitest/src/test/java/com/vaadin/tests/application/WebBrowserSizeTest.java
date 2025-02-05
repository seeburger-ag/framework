/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class WebBrowserSizeTest extends MultiBrowserTest {
    @Test
    public void testBrowserSize() {
        openTestURL();
        $(ButtonElement.class).first().click();
        // Thanks to selenium the browser size should always be 1500 x 850
        assertEquals("Browser size is not correct.", "1500 x 850",
                $(LabelElement.class).get(2).getText());
    }
}
