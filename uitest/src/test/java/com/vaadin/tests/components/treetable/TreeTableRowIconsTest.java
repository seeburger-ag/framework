/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.treetable;

import java.io.IOException;

import org.junit.Test;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class TreeTableRowIconsTest extends MultiBrowserTest {

    public final String SCREENSHOT_NAME = "TreeTableRowIcons";

    @Test
    public void checkScreenshot() throws IOException {
        openTestURL();
        compareScreen(SCREENSHOT_NAME);
    }

}
