/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.testbench.elements.TableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Test;

import java.io.IOException;

public class TableScrollsOnSelectionTest extends MultiBrowserTest {

    @Test
    public void tableIsNotScrolledOnSelect() throws IOException {
        openTestURL();

        TableElement table = $(TableElement.class).first();

        scrollTable(table, 80, 79);

        table.getCell(79, 0).click();

        compareScreen("scrolled-down");
    }
}