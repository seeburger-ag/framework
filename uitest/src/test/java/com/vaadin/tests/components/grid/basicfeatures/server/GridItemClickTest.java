/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures.server;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.testbench.elements.GridElement.GridCellElement;
import com.vaadin.tests.components.grid.basicfeatures.GridBasicFeaturesTest;

public class GridItemClickTest extends GridBasicFeaturesTest {

    @Test
    public void testItemClick() {
        openTestURL();

        selectMenuPath("Component", "State", "ItemClickListener");

        GridCellElement cell = getGridElement().getCell(3, 2);
        new Actions(getDriver()).moveToElement(cell).click().perform();

        assertTrue("No click in log",
                logContainsText(itemClickOn(3, 2, false)));
    }

    @Test
    public void testItemDoubleClick() {
        openTestURL();

        selectMenuPath("Component", "State", "ItemClickListener");

        GridCellElement cell = getGridElement().getCell(3, 2);
        new Actions(getDriver()).moveToElement(cell).doubleClick().perform();

        assertTrue("No double click in log",
                logContainsText(itemClickOn(3, 2, true)));
    }

    private String itemClickOn(int row, int column, boolean dblClick) {
        return "Item " + (dblClick ? "double " : "") + "click on Column "
                + column + ", item " + row;
    }
}
