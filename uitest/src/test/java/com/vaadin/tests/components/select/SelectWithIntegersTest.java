/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.select;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ListSelectElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class SelectWithIntegersTest extends SingleBrowserTest {
    @Test
    public void testSelectWithIntegers() {
        openTestURL();

        ListSelectElement defaultSelect = $(ListSelectElement.class)
                .caption("Default").first();
        ListSelectElement toStringSelect = $(ListSelectElement.class)
                .caption("ID_TOSTRING").first();

        Assert.assertEquals("2,014", defaultSelect.getOptions().get(0));
        Assert.assertEquals("2014", toStringSelect.getOptions().get(0));
    }
}
