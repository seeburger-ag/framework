/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.orderedlayout;

import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.testbench.elements.HorizontalLayoutElement;
import com.vaadin.testbench.elements.VerticalLayoutElement;
import com.vaadin.tests.tb3.TooltipTest;

public class TooltipOnRequiredIndicatorTest extends TooltipTest {

    @Test
    public void testTooltipOnRequiredIndicator() throws Exception {
        openTestURL();

        // gwt-uid-* are not stable across browsers etc. so need to look them up

        // caption
        checkTooltip(
                $(VerticalLayoutElement.class).get(1)
                        .findElement(By.className("v-captiontext")),
                "Vertical layout tooltip");
        // required indicator
        checkTooltip(By.className("v-required-field-indicator"),
                "Vertical layout tooltip");

        // caption
        checkTooltip(
                $(HorizontalLayoutElement.class).first()
                        .findElement(By.className("v-captiontext")),
                "Horizontal layout tooltip");
        // required indicator
        checkTooltip(
                $(HorizontalLayoutElement.class).first().findElement(
                        By.className("v-required-field-indicator")),
                "Horizontal layout tooltip");
    }
}