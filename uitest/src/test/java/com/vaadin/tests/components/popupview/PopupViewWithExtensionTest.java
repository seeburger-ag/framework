/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Popup view with extension should not throw an exception.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class PopupViewWithExtensionTest extends MultiBrowserTest {

    @Test
    public void testPopupView() {
        setDebug(true);
        openTestURL();

        WebElement view = driver.findElement(By.className("v-popupview"));
        view.click();

        assertNoErrorNotifications();
    }

}
