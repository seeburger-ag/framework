/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layoutmanager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class LayoutDuringStateUpdateTest extends SingleBrowserTest {

    @Test
    public void layoutDuringStateUpdate() {
        openTestURL();
        waitUntilLoadingIndicatorNotVisible();

        // add the custom component
        $(ButtonElement.class).first().click();
        waitUntilLoadingIndicatorNotVisible();

        // ensure the layouting failed to be triggered during the state update
        WebElement label = findElement(By.className("gwt-Label"));
        assertEquals("Layout phase count: 1", label.getText());
    }

}
