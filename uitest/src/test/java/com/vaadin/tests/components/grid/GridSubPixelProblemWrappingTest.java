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
import com.vaadin.testbench.elements.GridElement.GridRowElement;
import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.MultiBrowserTest;

@TestCategory("grid")
public class GridSubPixelProblemWrappingTest extends MultiBrowserTest {

    @Test
    public void addedRowShouldNotWrap() {
        openTestURL();

        GridElement grid = $(GridElement.class).first();

        // Cells in first row should be at the same y coordinate as the row
        assertRowAndCellTops(grid, 0);

        // Add a row
        $(ButtonElement.class).first().click();

        // Cells in the first row should be at the same y coordinate as the row
        assertRowAndCellTops(grid, 0);
        // Cells in the second row should be at the same y coordinate as the row
        assertRowAndCellTops(grid, 1);
    }

    private void assertRowAndCellTops(GridElement grid, int rowIndex) {
        GridRowElement row = grid.getRow(rowIndex);
        int rowTop = row.getLocation().y;

        int cell0Top = grid.getCell(rowIndex, 0).getLocation().y;
        int cell1Top = grid.getCell(rowIndex, 1).getLocation().y;
        Assert.assertEquals(rowTop, cell0Top);
        Assert.assertEquals(rowTop, cell1Top);
    }
}
