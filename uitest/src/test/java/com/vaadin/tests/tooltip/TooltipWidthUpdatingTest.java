/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tooltip;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.TooltipTest;

public class TooltipWidthUpdatingTest extends TooltipTest {

    @Test
    public void testTooltipWidthUpdating() {
        openTestURL();

        WebElement btnLongTooltip = vaadinElementById("longTooltip");
        WebElement btnShortTooltip = vaadinElementById("shortTooltip");

        moveMouseToTopLeft(btnLongTooltip);
        testBenchElement(btnLongTooltip).showTooltip();

        moveMouseToTopLeft(btnShortTooltip);
        testBenchElement(btnShortTooltip).showTooltip();

        assertThat(getDriver().findElement(By.className("popupContent"))
                .getSize().getWidth(),
                lessThan(TooltipWidthUpdating.MAX_WIDTH));
    }

}