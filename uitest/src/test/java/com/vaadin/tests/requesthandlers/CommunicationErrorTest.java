/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.requesthandlers;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for null values in communication error json object .
 *
 * @author Vaadin Ltd
 */
public class CommunicationErrorTest extends MultiBrowserTest {

    @Test
    public void testRedirection() {
        openTestURL();

        $(ButtonElement.class).first().click();

        Assert.assertTrue(isElementPresent(By.className("redirected")));
    }

}
