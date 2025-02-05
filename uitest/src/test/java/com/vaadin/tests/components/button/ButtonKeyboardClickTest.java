/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.button;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for availability (x,y) coordinates for button activated via keyboard.
 *
 * @author Vaadin Ltd
 */
public class ButtonKeyboardClickTest extends MultiBrowserTest {

    @Test
    public void testCoordinatesForClickedButtonViaSpace() {
        openTestURL();

        WebElement button = getDriver().findElement(By.className("v-button"));
        button.sendKeys(Keys.SPACE);

        checkCoordinates(button);
    }

    @Test
    public void testCoordinatesForClickedButtonViaEnter() {
        openTestURL();

        WebElement button = getDriver().findElement(By.className("v-button"));
        button.sendKeys(Keys.ENTER);

        checkCoordinates(button);
    }

    private void checkCoordinates(WebElement button) {
        int xRelative = getValue("xRelative");
        Assert.assertTrue(
                "X relative click coordinate is greater than middle of the button",
                button.getSize().getWidth() / 2 >= xRelative - 1);
        Assert.assertTrue(
                "X relative click coordinate is lower than middle of the button",
                button.getSize().getWidth() / 2 <= xRelative + 1);

        int yRelative = getValue("yRelative");
        Assert.assertTrue(
                "Y relative click coordinate is greater than middle of the button",
                button.getSize().getHeight() / 2 >= yRelative - 1);
        Assert.assertTrue(
                "Y relative click coordinate is lower than middle of the button",
                button.getSize().getHeight() / 2 <= yRelative + 1);

        Assert.assertTrue(
                "Client X click cooridnate is lower than X button coordinate",
                getValue("x") > button.getLocation().getX());
        Assert.assertTrue(
                "Client X click cooridnate is greater than right button "
                        + "border coordinate",
                getValue("x") < button.getLocation().getX()
                        + button.getSize().getWidth());

        Assert.assertTrue(
                "Client Y click cooridnate is lower than Y button coordinate",
                getValue("y") > button.getLocation().getY());
        Assert.assertTrue(
                "Client Y click cooridnate is greater than bottom button "
                        + "border coordinate",
                getValue("y") < button.getLocation().getY()
                        + button.getSize().getHeight());

        Assert.assertTrue(
                "Client X click cooridnate is greater than X middle button "
                        + "coordinate",
                button.getLocation().getX()
                        + button.getSize().getWidth() / 2 >= getValue("x") - 1);
        Assert.assertTrue(
                "Client Y click cooridnate is greater than Y middle button coordinate",
                button.getLocation().getY()
                        + button.getSize().getHeight() / 2 >= getValue("y")
                                - 1);

        Assert.assertTrue(
                "Client X click cooridnate is lower than X middle button "
                        + "coordinate",
                button.getLocation().getX()
                        + button.getSize().getWidth() / 2 <= getValue("x") + 1);
        Assert.assertTrue(
                "Client Y click cooridnate is lower than Y middle button coordinate",
                button.getLocation().getY()
                        + button.getSize().getHeight() / 2 <= getValue("y")
                                + 1);
    }

    private int getValue(String style) {
        return Integer.parseInt(getDriver()
                .findElement(By.className("v-label-" + style)).getText());
    }

}
