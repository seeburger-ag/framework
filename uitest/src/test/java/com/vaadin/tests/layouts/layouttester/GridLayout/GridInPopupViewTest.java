/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.GridLayout;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.By;
import com.vaadin.testbench.elements.GridElement;
import com.vaadin.testbench.elements.PopupViewElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class GridInPopupViewTest extends SingleBrowserTest {

    @Test
    public void popupViewClosedProperly() {
        openTestURL();
        PopupViewElement pv = $(PopupViewElement.class).first();
        pv.click();
        GridElement grid = $(GridElement.class).first();
        grid.getCell(5, 0).click();
        findElement(By.className("v-ui")).click();

        Assert.assertTrue($(GridElement.class).all().isEmpty());
        Assert.assertEquals("1. Selection: Alice", getLogRow(0));
    }
}
