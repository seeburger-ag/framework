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

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.testbench.commands.TestBenchElementCommands;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class TableTooManyColumnsTest extends MultiBrowserTest {

    @Test
    public void testDropdownTable() throws IOException {
        openTestURL();

        WebElement element = findElement(
                By.className("v-table-column-selector"));

        element.click();

        WebElement menu = findElement(By.className("gwt-MenuBar-vertical"));

        TestBenchElementCommands scrollable = testBenchElement(menu);
        scrollable.scroll(3000);

        compareScreen(getScreenshotBaseName());
    }

}
