/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.WindowElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class ExtraWindowShownTest extends MultiBrowserTest {

    @Test
    public void testNoExtraWindowAfterClosing() throws Exception {
        openTestURL();

        openWindow();
        closeWindow();
        assertNoWindow();

        openWindow();
        closeWindow();
        assertNoWindow();
    }

    private void openWindow() {
        $(ButtonElement.class).first().click();
    }

    private void closeWindow() {
        $(WindowElement.class).$(ButtonElement.class).first().click();
    }

    private void assertNoWindow() {
        Assert.assertFalse("Window found when there should be none.",
                $(WindowElement.class).exists());
    }
}
