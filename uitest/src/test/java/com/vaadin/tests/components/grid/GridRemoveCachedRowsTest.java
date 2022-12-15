/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

/**
 * Verifies that there's no client side errors when removing a range of rows
 * starting from the visible ones and ending into the cached ones.
 */
public class GridRemoveCachedRowsTest extends SingleBrowserTest {

    @Test
    public void testNoClientExceptionWhenRemovingARangeOfRows() {
        setDebug(true);
        openTestURL();

        // do remove a range of rows
        $(ButtonElement.class).first().click();

        assertNoErrorNotifications();
    }
}
