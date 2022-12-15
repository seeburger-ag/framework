/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test whether adding the first item to a table calculates the table width
 * correctly
 *
 * @author Vaadin Ltd
 */
public class TableWidthItemRemoveTest extends MultiBrowserTest {
    @Test
    public void testWidthResizeOnItemAdd() {
        openTestURL();

        WebElement populateButton = driver
                .findElement(By.vaadin("//Button[caption=\"Populate\"]"));
        WebElement table = driver
                .findElement(By.vaadin("//Table[caption=\"My table\"]"));
        int original_width = table.getSize().getWidth();
        populateButton.click();
        Assert.assertTrue("Width changed on item add.",
                original_width == table.getSize().getWidth());
    }

}
