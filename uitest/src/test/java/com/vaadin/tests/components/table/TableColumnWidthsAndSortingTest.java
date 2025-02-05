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

public class TableColumnWidthsAndSortingTest extends MultiBrowserTest {

    @Test
    public void testHeaderHeight() {
        openTestURL();
        TableElement t = $(TableElement.class).first();

        assertHeaderCellHeight(t);

        // Sort according to age
        t.getHeaderCell(2).click();
        assertHeaderCellHeight(t);

        // Sort again according to age
        t.getHeaderCell(2).click();
        assertHeaderCellHeight(t);

    }

    private void assertHeaderCellHeight(TableElement t) {
        // Assert all headers are correct height (37px according to default
        // Valo)
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals("Height of header cell " + i + " is wrong", 37,
                    t.getHeaderCell(0).getSize().getHeight());
        }

    }
}
