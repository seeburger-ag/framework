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

import com.vaadin.testbench.elements.TableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class SelectableEditableTest extends MultiBrowserTest {
    @Test
    public void testSelectFromCellWith() throws Exception {
        openTestURL();
        TableElement table = $(TableElement.class).first();
        table.getCell(0, 1).click();
        Assert.assertTrue("Element does not have the 'v-selected' css class",
                hasCssClass(table.getRow(0), "v-selected"));
    }
}
