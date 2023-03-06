/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.treetable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.TreeTableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests that expanded cells with component contents aren't empty.
 *
 * @author Vaadin Ltd
 */
public class DisappearingComponentsTest extends MultiBrowserTest {

    @Test
    public void testNotification() throws InterruptedException {
        openTestURL();

        TreeTableElement treeTable = $(TreeTableElement.class).first();
        treeTable.getCell(1, 0)
                .findElement(By.className("v-treetable-treespacer")).click();
        sleep(100);

        WebElement link = treeTable.getCell(2, 1)
                .findElement(By.className("v-link"));
        assertEquals("3", link.getText());
    }

}
