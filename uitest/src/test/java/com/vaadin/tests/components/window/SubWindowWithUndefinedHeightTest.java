/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import java.io.IOException;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TabSheetElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class SubWindowWithUndefinedHeightTest extends MultiBrowserTest {

    @Test
    public void testUndefinedWindowSizeUpdate() throws IOException {
        openTestURL();

        $(ButtonElement.class).caption("click me").first().click();
        compareScreen("initial-tab1");

        $(TabSheetElement.class).first().openTab("tab 2");
        compareScreen("select-tab2");

        $(TabSheetElement.class).first().openTab("Tab 1");
        compareScreen("select-tab1");
    }
}
