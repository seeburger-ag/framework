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
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test case creating and deleting table component in a loop, testing memory
 * lead in Table component. This test should not be used in auto testing.
 *
 * To test memory consuption. Run test in debug mode. Take memory snapshot in
 * Profiler in browser before and after the loop. Compare memory consuption.
 *
 * @since
 * @author Vaadin Ltd
 */
public class MemoryLeakTableTest extends MultiBrowserTest {

    /**
     *
     */
    private static final int ITERATIONS = 200;

    // To run locally in chrome download ChromeDriver for TB3
    // Set path to the chrome driver. In
    // ./work/eclipse-run-selected-test.properties add line
    // chrome.driver.path=path_to_driver

    // Test is marked as ignore to exclude it from auto testing
    @Test
    @Ignore
    public void memoryTest() throws IOException {
        // Set breakoint and look memory consuption in Profiler
        // Mozilla Firefox doesn't provide memory usage profiler, use chrome.

        openTestURL();

        ButtonElement btnAdd = $(ButtonElement.class).get(0);

        for (int i = 0; i < ITERATIONS; i++) {
            btnAdd.click();
            ButtonElement btnDel = $(ButtonElement.class).get(1);
            TableElement tbl = $(TableElement.class).get(0);
            Random rand = new Random();
            int scrollValue = rand.nextInt(1500);
            scrollTable(tbl, scrollValue);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            btnDel.click();
        }
        // Set breakoint and look memory consuption in Profiler
        btnAdd = $(ButtonElement.class).get(0);
    }

    // Scrolls table element
    // Method scroll in TalbeElement class has a bug
    //
    private void scrollTable(TableElement tbl, int value) {
        WebElement actualElement = tbl
                .findElement(By.className("v-table-body-wrapper"));
        JavascriptExecutor js = tbl.getCommandExecutor();
        js.executeScript("arguments[0].scrollTop = " + value, actualElement);
    }
}
