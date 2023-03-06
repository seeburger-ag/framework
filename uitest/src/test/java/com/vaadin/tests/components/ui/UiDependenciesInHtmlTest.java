/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class UiDependenciesInHtmlTest extends SingleBrowserTest {

    @Test
    public void testUiDependencisInHtml() {
        openTestURL();

        String statusText = findElement(By.id("statusBox")).getText();

        Assert.assertEquals(
                "Script loaded before vaadinBootstrap.js: true\nStyle tag before vaadin theme: true",
                statusText);
    }

}
