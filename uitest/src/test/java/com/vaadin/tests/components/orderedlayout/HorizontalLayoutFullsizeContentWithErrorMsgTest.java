/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.orderedlayout;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class HorizontalLayoutFullsizeContentWithErrorMsgTest
        extends MultiBrowserTest {

    @Test
    public void test() {
        openTestURL();
        WebElement element = getDriver().findElement(
                By.id(HorizontalLayoutFullsizeContentWithErrorMsg.FIELD_ID));
        Point location = element.getLocation();

        WebElement errorToggleButton = getDriver().findElement(
                By.id(HorizontalLayoutFullsizeContentWithErrorMsg.BUTTON_ID));

        errorToggleButton.click();

        Assert.assertEquals(location, element.getLocation());

        errorToggleButton.click();

        Assert.assertEquals(location, element.getLocation());

    }

}
