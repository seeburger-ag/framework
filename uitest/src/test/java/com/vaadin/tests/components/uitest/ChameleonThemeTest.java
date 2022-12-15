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

public class ChameleonThemeTest extends ThemeTest {
    @Override
    protected String getTheme() {
        return "chameleon";
    }

    @Override
    protected void testWindows() throws IOException {
        super.testWindows();

        // chameleon theme only
        testWindow(4, "subwindow-opaque");
    }
}
