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
import org.openqa.selenium.By;

import com.vaadin.testbench.elements.CheckBoxElement;
import com.vaadin.testbench.elements.GridElement;
import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.SingleBrowserTest;

@TestCategory("grid")
public class GridCheckBoxDisplayTest extends SingleBrowserTest {
    @Test
    public void testAddRow() {
        openTestURL();

        GridElement grid = $(GridElement.class).first();

        Assert.assertEquals("First item had wrong value", "true",
                grid.getCell(0, 0).getText());
        Assert.assertEquals("Second item had wrong value", "false",
                grid.getCell(1, 0).getText());

        // First edit false item and see that the CheckBox is unchecked
        grid.getCell(1, 0).doubleClick();

        CheckBoxElement checkbox = $(CheckBoxElement.class).first();
        Assert.assertEquals("CheckBox was checked", "unchecked",
                checkbox.getValue());

        closeEditor();

        // Edit true item and see that the CheckBox is checked
        grid.getCell(0, 0).doubleClick();

        checkbox = $(CheckBoxElement.class).first();
        Assert.assertEquals("CheckBox was not checked.", "checked",
                checkbox.getValue());

        closeEditor();

        // Edit false item and confirm that the CheckBox is unchecked again
        grid.getCell(1, 0).doubleClick();

        checkbox = $(CheckBoxElement.class).first();
        Assert.assertEquals("CheckBox was checked", "unchecked",
                checkbox.getValue());
    }

    /**
     * Closes the grids editor using the cancel button
     */
    private void closeEditor() {
        findElement(By.className("v-grid-editor-cancel")).click();
    }
}
