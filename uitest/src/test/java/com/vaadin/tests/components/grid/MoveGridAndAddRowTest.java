/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.GridElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class MoveGridAndAddRowTest extends SingleBrowserTest {

    @Test
    public void addRowAndChangeLayout() {
        openTestURL();
        $(ButtonElement.class).id("add").click();

        GridElement grid = $(GridElement.class).first();
        Assert.assertEquals("1", grid.getCell(0, 0).getText());
        Assert.assertEquals("2", grid.getCell(1, 0).getText());
    }
}
