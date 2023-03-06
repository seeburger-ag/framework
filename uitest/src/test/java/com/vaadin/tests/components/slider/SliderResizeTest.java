/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.slider;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class SliderResizeTest extends MultiBrowserTest {

    @Test
    public void resizeSlider() throws IOException {
        openTestURL();

        // Verify the starting position.
        assertEquals("488px", getSliderHandlePosition());

        // Click on the button that reduces the layout width by 200px.
        driver.findElement(By.className("v-button")).click();

        // Assert that the slider handle was also moved.
        assertEquals("288px", getSliderHandlePosition());
    }

    private String getSliderHandlePosition() {
        WebElement handle = driver.findElement(By.className("v-slider-handle"));
        return handle.getCssValue("margin-left");
    }

}
