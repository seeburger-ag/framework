/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.vaadin.testbench.elements.ColorPickerElement;
import com.vaadin.tests.components.colorpicker.DefaultCaptionWidthTest;

/**
 * Test for default caption behavior in color picker using Valo theme.
 *
 * @author Vaadin Ltd
 */
public class ValoDefaultCaptionWidthTest extends DefaultCaptionWidthTest {

    @Override
    @Test
    public void setDefaultCaption_sizeAndCaptionAreNotSet_pickerGetsStyle() {
        super.setDefaultCaption_sizeAndCaptionAreNotSet_pickerGetsStyle();
        int width = $(ColorPickerElement.class).first().getSize().getWidth();
        // Make sure that implicit width is less than one that will be
        // explicitly set by the test
        assertThat("Width of color picker is overriden by "
                + "default caption feature", width, is(lessThan(148)));
    }

    @Override
    @Test
    public void setDefaultCaption_explicitSizeIsSet_pickerNoCaptionStyle() {
        super.setDefaultCaption_explicitSizeIsSet_pickerNoCaptionStyle();
        int width = $(ColorPickerElement.class).first().getSize().getWidth();
        // Width should be 150px but let's just check that it's not which is
        // used when default caption is used and at least >= 150-1
        assertThat(
                "Width of color picker is overriden by "
                        + "default caption feature",
                width, is(greaterThan(149)));
    }
}
