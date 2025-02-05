/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class CloseModalSubWindowTest extends MultiBrowserTest {

    @Test
    public void testCloseModalSubWindow() throws Exception {

        openTestURL();

        // assert that there's a button with a 'del-btn0' id
        List<WebElement> buttons = getDriver()
                .findElements(By.id(CloseModalSubWindow.DELETE_BUTTON + "0"));
        int deleteButtonCount = buttons.size();
        Assert.assertEquals(1, deleteButtonCount);

        // assert that there's no sub-windows open
        List<WebElement> subWindows = getDriver()
                .findElements(By.id(CloseModalSubWindow.SUB_WINDOW));
        Assert.assertEquals(0, subWindows.size());

        // click the first delete button
        getFirstDeteleButton(0).click();

        // assert that there's ONE sub-window open
        subWindows = getDriver()
                .findElements(By.id(CloseModalSubWindow.SUB_WINDOW));
        Assert.assertEquals(1, subWindows.size());

        WebElement confirm = getDriver()
                .findElement(By.id(CloseModalSubWindow.CONFIRM_BUTTON));

        // click the confirm button in the sub-window
        confirm.click();

        // assert that there's no sub-windows open
        subWindows = getDriver()
                .findElements(By.id(CloseModalSubWindow.SUB_WINDOW));
        Assert.assertEquals(0, subWindows.size());

        // assert that there's no button with 'del-btn0' id anymore
        buttons = getDriver()
                .findElements(By.id(CloseModalSubWindow.DELETE_BUTTON + "0"));
        Assert.assertEquals(0, buttons.size());
    }

    private WebElement getFirstDeteleButton(int index) {
        WebElement button = getDriver()
                .findElement(By.id(CloseModalSubWindow.DELETE_BUTTON + index));
        return button;
    }
}
