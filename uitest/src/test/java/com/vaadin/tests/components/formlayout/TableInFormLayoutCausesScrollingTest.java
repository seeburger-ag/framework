/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.formlayout;

import com.vaadin.testbench.elements.TableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class TableInFormLayoutCausesScrollingTest extends MultiBrowserTest {

    @Test
    @Ignore
    // This test is actually testing that #7309 is NOT fixed.
    // Ignoring the test because it is not stable and it's
    // occasionally failing on browsers even when it shouldn't.
    // There's no point fixing this test before #7309 is actually fixed.
    public void pageIsNotScrolled() throws IOException {
        openTestURL();

        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();

        $(TableElement.class).first().getCell(2, 0).click();

        compareScreen("scrolledDown");
    }
}