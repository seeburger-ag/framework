/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tooltip;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.TooltipTest;

/**
 * Test if tooltips in subwindows behave correctly
 *
 * @author Vaadin Ltd
 */
public class TooltipInWindowTest extends TooltipTest {

    @Test
    public void testTooltipsInSubWindow() throws Exception {
        openTestURL();

        WebElement textfield = vaadinElementById("tf1");

        checkTooltip(textfield, "My tooltip");

        ensureVisibleTooltipPositionedCorrectly(textfield);

        clearTooltip();

        checkTooltip(textfield, "My tooltip");

        clearTooltip();
    }

    private WebElement getTooltipContainerElement() {
        return getDriver().findElement(By.className("v-tooltip"));
    }

    private void ensureVisibleTooltipPositionedCorrectly(WebElement textfield)
            throws InterruptedException {
        int tooltipX = getTooltip().getLocation().getX();
        int textfieldX = textfield.getLocation().getX();
        assertGreaterOrEqual("Tooltip should be positioned on the textfield ("
                + tooltipX + " < " + textfieldX + ")", tooltipX, textfieldX);
    }

    private void ensureHiddenTooltipPositionedCorrectly() {
        int tooltipX = getTooltipContainerElement().getLocation().getX();
        assertLessThanOrEqual(
                "Tooltip should be positioned outside of viewport (was at "
                        + tooltipX + ")",
                tooltipX, -1000);
    }
}
