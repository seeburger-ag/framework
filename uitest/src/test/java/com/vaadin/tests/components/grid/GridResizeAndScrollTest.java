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

import com.vaadin.testbench.elements.GridElement;
import com.vaadin.testbench.elements.GridElement.GridCellElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class GridResizeAndScrollTest extends MultiBrowserTest {

    @Test
    public void scrollAndClick() {
        openTestURL();
        GridElement grid = $(GridElement.class).first();
        grid.scrollToRow(49);
        // select a row (click on checkbox)
        grid.getCell(49, 0).click();

        // verify rows are what they should be
        GridCellElement cell = grid.getCell(33, 1);
        String textBefore = cell.getText();
        cell.click();

        Assert.assertEquals("String contents changed on click", textBefore,
                cell.getText());

    }

}
