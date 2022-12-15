/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.nativeselect;

import com.vaadin.tests.tb3.SingleBrowserTest;
import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.NativeSelectElement;

public class NativeSelectNullTest extends SingleBrowserTest {
    @Test
    public void selectNull() {
        openTestURL();
        NativeSelectElement select = $(NativeSelectElement.class).first();
        select.selectByText("Item");
        Assert.assertEquals("1. Value: Item", getLogRow(0));
        select.selectByText("");
        Assert.assertEquals("2. Value: null", getLogRow(0));
    }
}
