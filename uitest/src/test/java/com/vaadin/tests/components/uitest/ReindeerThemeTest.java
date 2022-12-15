/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.uitest;

import java.io.IOException;

public class ReindeerThemeTest extends ThemeTest {
    @Override
    protected String getTheme() {
        return "reindeer";
    }

    @Override
    protected void testWindows() throws IOException {
        super.testWindows();

        // reindeer theme only
        testWindow(1, "subwindow-light");
        testWindow(2, "subwindow-black");
    }
}
