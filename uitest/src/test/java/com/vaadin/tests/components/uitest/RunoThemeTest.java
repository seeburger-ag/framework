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

public class RunoThemeTest extends ThemeTest {
    @Override
    protected String getTheme() {
        return "runo";
    }

    @Override
    protected void testWindows() throws IOException {
        super.testWindows();

        // runo theme only
        testWindow(3, "subwindow-dialog");
    }
}
