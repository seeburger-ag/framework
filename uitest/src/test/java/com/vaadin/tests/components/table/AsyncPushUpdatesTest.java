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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test to see if VScrollTable handles Push updates correctly.
 *
 * @author Vaadin Ltd
 */
public class AsyncPushUpdatesTest extends MultiBrowserTest {

    @Test(expected = NoSuchElementException.class)
    public void InsertedRowsAreNotDuplicated() {
        openTestURL();

        WebElement button = $(ButtonElement.class).first();

        button.click();

        $(TableElement.class).first().getCell(12, 0);
        Assert.fail("Duplicates are present.");
    }

}
