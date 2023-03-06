/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tree;

import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.components.table.DndTableTargetDetailsTest;

/**
 * Test for mouse details in AbstractSelectTargetDetails class when DnD target
 * is a tree.
 *
 * @author Vaadin Ltd
 */
public class DndTreeTargetDetailsTest extends DndTableTargetDetailsTest {

    @Override
    protected WebElement getTarget() {
        return findElement(By.className("target"));
    }

}
