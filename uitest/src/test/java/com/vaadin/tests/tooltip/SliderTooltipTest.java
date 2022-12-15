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

import com.vaadin.testbench.elements.SliderElement;
import com.vaadin.tests.tb3.TooltipTest;

/**
 * Test that sliders can have tooltips
 *
 * @author Vaadin Ltd
 */
public class SliderTooltipTest extends TooltipTest {

    @Test
    public void sliderHasTooltip() throws Exception {
        openTestURL();
        WebElement slider = $(SliderElement.class).first();
        checkTooltipNotPresent();
        checkTooltip(slider, "Tooltip");
        clearTooltip();
        checkTooltipNotPresent();
    }
}
