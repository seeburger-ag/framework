/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import org.junit.Test;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class TabBarWidthTest extends MultiBrowserTest {

    @Test
    public void testWidths() throws Exception {
        openTestURL();

        // Initial rendering.
        compareScreen("tab-bar-width-init");

        // Remove all widths.
        vaadinElementById("toggleWidths").click();
        compareScreen("tab-bar-width-undefined");

        // Restore all widths. This should restore the rendering to the same
        // point as the initial rendering.
        vaadinElementById("toggleWidths").click();
        compareScreen("tab-bar-width-restored");
    }

}
