/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.DndActionsTest;

/**
 * Test for mouse details in AbstractSelectTargetDetails class when DnD target
 * is a table.
 *
 * @author Vaadin Ltd
 */
public class DndTableTargetDetailsTest extends DndActionsTest {

    @Test
    public void testMouseDetails() throws IOException, InterruptedException {
        openTestURL();

        WebElement row = findElement(By.className("v-table-cell-wrapper"));

        dragAndDrop(row, getTarget());

        WebElement label = findElement(By.className("dnd-button-name"));
        Assert.assertEquals("Button name=left", label.getText());
    }

    protected WebElement getTarget() {
        return findElement(By.className("target"))
                .findElement(By.className("v-table-cell-wrapper"));
    }

}
