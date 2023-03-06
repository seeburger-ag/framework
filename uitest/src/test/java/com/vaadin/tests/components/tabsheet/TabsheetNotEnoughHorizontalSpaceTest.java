/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import java.io.IOException;

import org.junit.Test;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests that tabsheet's scroll button are rendered correctly in Chameleon
 * theme.
 *
 * Ticket #12154
 *
 * @since
 * @author Vaadin Ltd
 */
public class TabsheetNotEnoughHorizontalSpaceTest extends MultiBrowserTest {

    @Test
    public void testThatTabScrollButtonsAreRenderedCorrectly()
            throws IOException {
        openTestURL();

        driver.findElement(By.className("v-tabsheet-scrollerPrev-disabled"));
        driver.findElement(By.className("v-tabsheet-scrollerNext"));

        compareScreen(getScreenshotBaseName());
    }

}
