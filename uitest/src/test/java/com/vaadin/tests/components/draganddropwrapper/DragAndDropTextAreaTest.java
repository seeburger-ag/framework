/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.draganddropwrapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for drag image of text area which should contain text-area text.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class DragAndDropTextAreaTest extends MultiBrowserTest {

    @Test
    public void testTextAreaDndImage() {
        openTestURL();

        WebElement wrapper = driver
                .findElement(By.className("v-verticallayout"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(wrapper);
        actions.moveByOffset(50, 50);
        actions.perform();

        WebElement dragElement = driver
                .findElement(By.className("v-drag-element"));
        List<WebElement> children = dragElement.findElements(By.xpath(".//*"));
        boolean found = false;
        for (WebElement child : children) {
            if ("text".equals(child.getAttribute("value"))) {
                found = true;
            }
        }

        Assert.assertTrue(
                "Text value is not found in the DnD image of text area", found);
    }

}
