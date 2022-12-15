/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.gridlayout;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.GridLayoutElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class GridLayoutRequiredIndicatorLocationTest extends MultiBrowserTest {

    private WebElement gridLayoutSlot;

    @Override
    public void setup() throws Exception {
        super.setup();
        openTestURL();
        gridLayoutSlot = $(GridLayoutElement.class).first()
                .findElement(By.className("v-gridlayout-slot"));
    }

    @Test
    public void testRequiredIndicatorLocationLeftFixedField() {
        assertIndicatorPosition(getSlot(1));
    }

    @Test
    public void testRequiredIndicatorLocationLeftRelativeField() {
        assertIndicatorPosition(getSlot(3));
    }

    @Test
    public void testRequiredIndicatorLocationLeft100PercentField() {
        assertIndicatorPosition(getSlot(5));
    }

    @Test
    public void testRequiredIndicatorLocationCenterFixedField() {
        assertIndicatorPosition(getSlot(7));
    }

    @Test
    public void testRequiredIndicatorLocationCenterRelativeField() {
        assertIndicatorPosition(getSlot(9));
    }

    @Test
    public void testRequiredIndicatorLocationCenter100PercentField() {
        assertIndicatorPosition(getSlot(11));
    }

    @Test
    public void testRequiredIndicatorLocationRightFixedField() {
        assertIndicatorPosition(getSlot(13));
    }

    @Test
    public void testRequiredIndicatorLocationRightRelativeField() {
        assertIndicatorPosition(getSlot(15));
    }

    @Test
    public void testRequiredIndicatorLocationRight100PercentField() {
        assertIndicatorPosition(getSlot(17));
    }

    private void assertIndicatorPosition(WebElement slot) {
        WebElement field = slot.findElement(By.tagName("input"));
        WebElement caption = slot.findElement(By.className("v-caption"));

        int desiredIndicatorPosition = field.getLocation().getX()
                + field.getSize().getWidth();
        int actualIndicatorPosition = caption.getLocation().getX();

        Assert.assertEquals("Required indicator has wrong position",
                desiredIndicatorPosition, actualIndicatorPosition, 1d);
    }

    @Test
    public void testScreenshotMatches() throws IOException {
        compareScreen("indicators");
    }

    private WebElement getSlot(int index) {
        return gridLayoutSlot.findElements(By.className("v-gridlayout-slot"))
                .get(index);
    }
}
