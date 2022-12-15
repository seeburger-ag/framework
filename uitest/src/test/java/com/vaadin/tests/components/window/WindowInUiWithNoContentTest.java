/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for Window attached to the UI with not content.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class WindowInUiWithNoContentTest extends MultiBrowserTest {

    @Test
    public void testWindowInEmptyUI() {
        openTestURL();

        WebElement window = driver.findElement(By.className("v-window"));
        String position = window.getCssValue("position");

        Assert.assertEquals("Window element has non-absolute position and "
                + "is broken in the UI", "absolute", position);
    }

}
