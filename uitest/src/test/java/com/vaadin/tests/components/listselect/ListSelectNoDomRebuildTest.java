/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.listselect;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.testbench.elements.ListSelectElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class ListSelectNoDomRebuildTest extends SingleBrowserTest {
    @Override
    protected Class<?> getUIClass() {
        return ListSelects.class;
    }

    @Test
    public void testNoDomRebuild() {
        openTestURL();

        // Testbench doesn't seem to support sending key events to the right
        // location, so we will just verify that the DOM is not rebuilt
        selectMenuPath("Component", "Selection", "Multi select");
        selectMenuPath("Component", "Listeners", "Value change listener");

        ListSelectElement list = $(ListSelectElement.class).first();
        List<WebElement> options = list.findElements(By.tagName("option"));

        assertNotStale(options);

        options.get(4).click();

        assertNotStale(options);

        new Actions(driver).keyDown(Keys.SHIFT).perform();
        options.get(2).click();
        options.get(6).click();
        new Actions(driver).keyUp(Keys.SHIFT).perform();

        assertNotStale(options);
    }

    private void assertNotStale(List<WebElement> options) {
        for (WebElement element : options) {
            // We really don't expect the text to be null, mainly doing this
            // since getText() will throw if the element is detached.
            Assert.assertNotNull(element.getText());
        }
    }

}
