/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public abstract class BaseAddReplaceMoveTest extends MultiBrowserTest {
    @Test
    public void LayoutAlignment() throws IOException, InterruptedException {
        openTestURL();
        waitForElementPresent(By.className("v-table"));
        compareScreen("initial");
        String[] states = { "add", "replace", "move", "remove" };
        List<ButtonElement> buttons = $(ButtonElement.class).all();
        int index = 0;
        // go through all buttons click them and see result
        for (ButtonElement btn : buttons) {
            btn.click();
            waitForElementPresent(By.className("v-table"));
            compareScreen(states[index]);
            index++;
        }
    }
}