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

import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elements.TableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests Table Footer ClickListener
 *
 * @since
 * @author Vaadin Ltd
 */
public class HeaderPositionWhenSortingTest extends MultiBrowserTest {

    @Test
    public void testFooter() throws IOException {
        openTestURL();

        TableElement table = $(TableElement.class).first();
        TestBenchElement header1 = table.getHeaderCell(1);
        header1.click();

        compareScreen("sort-asc-died-at-age");

        header1.click();

        compareScreen("sort-desc-died-at-age");

        TestBenchElement header0 = table.getHeaderCell(0);
        header0.click();

        compareScreen("sort-asc-name");

        header0.click();

        compareScreen("sort-desc-name");
    }
}
