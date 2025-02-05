/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.colorpicker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.testbench.elements.ColorPickerElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for default caption behavior in color picker.
 *
 * @author Vaadin Ltd
 */
public class DefaultCaptionWidthTest extends MultiBrowserTest {

    @Before
    public void setUp() {
        openTestURL();
    }

    @Test
    public void setDefaultCaption_sizeAndCaptionAreNotSet_pickerGetsStyle() {
        checkStylePresence(true);
    }

    @Test
    public void setDefaultCaption_explicitSizeIsSet_pickerNoCaptionStyle() {
        findElement(By.className("set-width")).click();
        checkStylePresence(false);
    }

    @Test
    public void setDefaultCaption_explicitCaptionIsSet_pickerNoCaptionStyle() {
        findElement(By.className("set-caption")).click();
        checkStylePresence(false);
    }

    protected void checkStylePresence(boolean expectedStyle) {
        String clazz = $(ColorPickerElement.class).first()
                .getAttribute("class");
        if (expectedStyle) {
            Assert.assertTrue("Default caption style is not found",
                    clazz.contains("v-default-caption-width"));
        } else {
            Assert.assertFalse("Found unexpected default caption style",
                    clazz.contains("v-default-caption-width"));
        }
    }

}
