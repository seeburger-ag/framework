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

import com.vaadin.tests.tb3.MultiBrowserTest;

public class BrowserFrameDoubleScrollbarsTest extends MultiBrowserTest {

    @Test
    public void testWindowRepositioning() throws Exception {
        openTestURL();

        compareScreen("BrowserFrameDoubleScrollbars");
    }
}
