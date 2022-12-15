/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import com.vaadin.testbench.TestBenchElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test if the page scroll when press space on a tabsheet's tab.
 *
 * @since
 * @author Vaadin Ltd
 */
public class TabSpaceNotScrollTest extends MultiBrowserTest {

    @Test
    public void testScroll() throws InterruptedException, IOException {
        openTestURL();

        TestBenchElement tab = (TestBenchElement) getDriver()
                .findElement(By.className("v-tabsheet-tabitemcell"));
        tab.click(10, 10);

        Point oldLocation = tab.getLocation();

        tab.sendKeys(Keys.SPACE);

        Point newLocation = tab.getLocation();

        Assert.assertEquals(oldLocation, newLocation);
    }

}
