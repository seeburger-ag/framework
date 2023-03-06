/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.customlayout;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.vaadin.testbench.ElementQuery;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.CustomLayoutElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class CustomLayoutWithNullTemplateTest extends SingleBrowserTest {

    @Test
    public void testChildComponents() {
        openTestURL();

        ElementQuery<CustomLayoutElement> customLayout = $(
                CustomLayoutElement.class);

        // Verify the Button and Label are rendered inside the CustomLayout.
        assertTrue("Button was not rendered.",
                customLayout.$(ButtonElement.class).exists());
        assertTrue("Label was not rendered.",
                customLayout.$(LabelElement.class).exists());
    }

}
