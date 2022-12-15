/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.browserframe;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class BrowserFrameIsVisibleTest extends MultiBrowserTest {
    @Test
    public void testBrowserFrameDisplaysFiles() throws Exception {
        openTestURL();
        compareScreen("show_initial");
        $(ButtonElement.class).caption("Hello World").first().click();
        compareScreen("show_hello");
        $(ButtonElement.class).caption("Lorem ipsum").first().click();
        compareScreen("show_lorem");
        $(ButtonElement.class).caption("null").first().click();
        compareScreen("show_alternative_text");
        $(ButtonElement.class).caption("Lorem ipsum").first().click();
        compareScreen("show_lorem");
    }
}
