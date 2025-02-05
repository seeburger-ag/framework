/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.testbench.commands.TestBenchElementCommands;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class ScrollingBodyElementWithModalOpenedTest extends MultiBrowserTest {

    @Test
    public void testWindowScrollbars() throws Exception {
        openTestURL();

        WebElement bodyElement = driver
                .findElement(By.className("v-modal-window-open"));

        TestBenchElementCommands scrollable = testBenchElement(bodyElement);
        scrollable.scroll(1000);

        Thread.sleep(1000);

        compareScreen(getScreenshotBaseName());
    }

}
