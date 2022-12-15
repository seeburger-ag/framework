/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.listselect;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.ListSelectElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class ListSelectAddRemoveItemsTest extends SingleBrowserTest {
    @Test
    public void testAddAndRemove() {
        openTestURL();
        assertOptions("", "a", "b", "c");

        click("Add first");
        assertOptions("", "first", "a", "b", "c");

        click("Swap");
        assertOptions("", "c", "a", "b", "first");

        click("Remove first");
        assertOptions("", "a", "b", "first");

        click("Add middle");
        assertOptions("", "a", "middle", "b", "first");

        click("Add last");
        assertOptions("", "a", "middle", "b", "first", "last");

        click("Remove middle");
        assertOptions("", "a", "middle", "first", "last");

        click("Reset");
        assertOptions("", "a", "b", "c");
    }

    private void assertOptions(String... options) {
        Assert.assertEquals(Arrays.asList(options),
                $(ListSelectElement.class).first().getOptions());
    }

    private void click(String caption) {
        $(ButtonElement.class).caption(caption).first().click();
    }
}
