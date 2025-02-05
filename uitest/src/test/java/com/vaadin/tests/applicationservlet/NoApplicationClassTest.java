/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.applicationservlet;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class NoApplicationClassTest extends SingleBrowserTest {

    @Test
    public void testInvalidApplicationClass() {
        openTestURL();
        String exceptionMessage = getDriver().findElement(By.xpath("//pre[1]"))
                .getText();
        String expected = "ServletException: java.lang.ClassNotFoundException: ClassThatIsNotPresent";
        Assert.assertTrue(
                String.format(
                        "Unexpected error message.\n expected to contain: '%s'\n was: %s",
                        expected, exceptionMessage),
                exceptionMessage.contains(expected));
    }

    @Override
    protected String getDeploymentPath() {
        return "/run/ClassThatIsNotPresent";
    }

    @Override
    protected void openTestURL(String... parameters) {
        driver.get(getTestUrl());
    }
}
