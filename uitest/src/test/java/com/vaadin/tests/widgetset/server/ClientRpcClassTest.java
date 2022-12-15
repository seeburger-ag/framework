/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class ClientRpcClassTest extends MultiBrowserTest {

    @Test
    public void pauseDisplayed() {
        openTestURL();

        WebElement element = getDriver()
                .findElement(By.id(ClientRpcClass.TEST_COMPONENT_ID));
        Assert.assertEquals("pause", element.getText());
    }
}
