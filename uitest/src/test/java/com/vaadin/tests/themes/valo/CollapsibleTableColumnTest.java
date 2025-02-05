/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.TableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for non-collapsible column opacity for item in column configuration
 * menu.
 *
 * @author Vaadin Ltd
 */
public class CollapsibleTableColumnTest extends MultiBrowserTest {

    @Test
    public void nonCollapsibleColumnOpacity() {
        openTestURL();

        // click on the header to make the column selector visible
        $(TableElement.class).first().getHeaderCell(0).click();
        waitForElementVisible(By.className("v-table-column-selector"));

        findElement(By.className("v-table-column-selector")).click();

        List<WebElement> items = findElements(By.className("v-on"));
        String collapsibleColumnOpacity = items.get(0).getCssValue("opacity");
        String nonCollapsibleColumnOpacity = items.get(1)
                .getCssValue("opacity");

        Assert.assertNotEquals(
                "Opacity value is the same for collapsible "
                        + "and non-collapsible column item",
                collapsibleColumnOpacity, nonCollapsibleColumnOpacity);
    }
}
