/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.customcomponent;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomComponentChildVisibilityTest extends MultiBrowserTest {

    @Test
    public void childVisibilityIsSet() {
        openTestURL();

        assertTrue(isChildElementVisible());

        $(ButtonElement.class).first().click();

        assertFalse(isChildElementVisible());
    }

    private boolean isChildElementVisible() {
        return $(LabelElement.class).all().size() > 1;
    }

}