/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.panel;

import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Test;
import org.openqa.selenium.By;


public class PanelHTMLCaptionTest extends MultiBrowserTest {
    @Test
    public void testCaptionDisplayedAsText() {
        openTestURL();
        assertElementNotPresent(By.id("divId"));
        findElement(By.id("buttonId")).click();
        assertElementPresent(By.id("divId"));
    }
}
