/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import com.vaadin.testbench.elements.GridElement;
import com.vaadin.tests.components.grid.basicfeatures.GridBasicFeaturesTest;

/**
 * @author Vaadin Ltd
 *
 */
public class HorizontalScrollAfterResizeTest extends GridBasicFeaturesTest {

    /**
     * The behavior without the fix differs across different browsers but
     * scenario should work everywhere.
     */
    @Test
    public void scrollAfterResize() {
        getDriver().manage().window().setSize(new Dimension(600, 400));
        openTestURL();
        getDriver().manage().window().setSize(new Dimension(200, 400));

        // First scroll to the right
        scrollGridHorizontallyTo(600);
        Point locationAfterFirstScroll = $(GridElement.class).first()
                .getCell(0, 9).getLocation();

        // resize back
        getDriver().manage().window().setSize(new Dimension(600, 400));
        // shrink again
        getDriver().manage().window().setSize(new Dimension(200, 400));

        // second scroll to the right
        scrollGridHorizontallyTo(600);

        Point lolocationAfterSecondScrollcation = $(GridElement.class).first()
                .getCell(0, 9).getLocation();

        // With the bug scrolling doesn't happen. Location should be the same as
        // first time
        Assert.assertEquals(locationAfterFirstScroll,
                lolocationAfterSecondScrollcation);
    }

    @Override
    protected Class<?> getUIClass() {
        return HorizontalScrollAfterResize.class;
    }
}
