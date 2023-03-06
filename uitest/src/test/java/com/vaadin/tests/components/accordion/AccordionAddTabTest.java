/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.accordion;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for Accordion : replace widget in tab should remove old widget.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class AccordionAddTabTest extends MultiBrowserTest {

    @Test
    public void testRemoveAndAdd() {
        openTestURL();

        WebElement button = driver.findElement(By.className("v-button"));
        button.click();

        List<WebElement> panels = driver.findElements(By.className("v-panel"));

        Assert.assertEquals(
                "Found two widgets inside one tab after "
                        + "subsequent tab removal and addition",
                1, panels.size());
    }

}
