/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class TableWithEmptyCaptionTest extends MultiBrowserTest {

    @Test
    public void testEmptyCaption() throws Exception {
        openTestURL();

        // Wait for the loading bar to disappear before taking the screenshot.
        try {
            waitUntil(ExpectedConditions.invisibilityOfElementLocated(
                    By.className("v-loading-indicator")), 5);
        } catch (TimeoutException e) {
            // Just take the screenshot, PhantomJS always times out.
        }

        compareScreen("table-empty-caption");
    }

}
