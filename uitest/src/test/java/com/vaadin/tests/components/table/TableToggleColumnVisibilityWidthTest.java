/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests that column keeps its width after it is made invisible and visible
 * again (#12303).
 *
 * @author Vaadin Ltd
 */
public class TableToggleColumnVisibilityWidthTest extends MultiBrowserTest {

    @Test
    public void testColumnWidthRestoredAfterTogglingVisibility() {
        openTestURL();

        int secondColumnWidthInitial = findElements(
                By.className("v-table-header-cell")).get(1).getSize()
                        .getWidth();
        ButtonElement toggleButton = $(ButtonElement.class).id("toggler");

        toggleButton.click();
        Assert.assertEquals("One column should be visible",
                findElements(By.className("v-table-header-cell")).size(), 1);

        toggleButton.click();
        Assert.assertEquals("Two columns should be visible",
                findElements(By.className("v-table-header-cell")).size(), 2);
        int secondColumnWidthRestored = findElements(
                By.className("v-table-header-cell")).get(1).getSize()
                        .getWidth();
        Assert.assertEquals(
                "Column width should be the same as it was before hiding",
                secondColumnWidthInitial, secondColumnWidthRestored);

    }

}
