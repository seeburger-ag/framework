/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.slider;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class HiddenSliderHandleTest extends MultiBrowserTest {

    @Test
    public void handleIsAccessible() throws IOException {
        openTestURL();

        assertThat(getSliderHandle().isDisplayed(), is(true));
    }

    private WebElement getSliderHandle() {
        return driver.findElement(By.className("v-slider-handle"));
    }
}
