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
 * Tests Table Footer ClickListener
 *
 * @since
 * @author Vaadin Ltd
 */
public class TableVisibleColumnsUpdateTest extends MultiBrowserTest {

    @Test
    public void testFooter() throws IOException {
        openTestURL();

        compareScreen("first");

        $(ButtonElement.class).first().click();

        compareScreen("second");

        $(ButtonElement.class).first().click();

        compareScreen("first2");

        $(ButtonElement.class).first().click();

        compareScreen("second2");

    }
}
