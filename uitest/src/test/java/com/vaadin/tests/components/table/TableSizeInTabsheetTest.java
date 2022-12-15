/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import static com.vaadin.tests.components.table.TableSizeInTabsheet.TABLE;
import static com.vaadin.tests.components.table.TableSizeInTabsheet.TABSHEET;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class TableSizeInTabsheetTest extends MultiBrowserTest {

    private static final String TABSHEET_CONTENT_STYLENAME = "v-tabsheet-content";

    @Test
    public void testTabsheetContentHasTheSameHeightAsTable() {
        openTestURL();
        int tableHeight = getTableHeigth();
        int tabSheetContentHeight = getTableSheetContentHeight();

        Assert.assertEquals(tableHeight, tabSheetContentHeight);
    }

    private int getTableHeigth() {
        return vaadinElementById(TABLE).getSize().getHeight();
    }

    private int getTableSheetContentHeight() {
        WebElement tabsheetContent = vaadinElementById(TABSHEET)
                .findElement(By.className(TABSHEET_CONTENT_STYLENAME));
        return tabsheetContent.getSize().getHeight();
    }
}
