/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures.client;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.components.grid.basicfeatures.GridBasicClientFeaturesTest;

@SuppressWarnings("all")
public class GridClientStructureTest extends GridBasicClientFeaturesTest {
    @Test
    public void haederDecoSizeShouldBeRecalculated() {
        // it's easier to notice with valo
        openTestURL("theme=valo");

        WebElement topDeco = getGridElement()
                .findElement(By.className("v-grid-header-deco"));
        assertGreater(
                "The header deco in Valo hasn't been recalculated after initial rendering",
                topDeco.getSize().getHeight(), 20);
    }
}
