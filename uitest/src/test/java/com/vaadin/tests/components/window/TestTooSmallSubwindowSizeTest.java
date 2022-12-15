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

import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests that the styles work correctly in tiny subwindows that have more
 * content than can fit.
 *
 * @author Vaadin Ltd
 */
public class TestTooSmallSubwindowSizeTest extends MultiBrowserTest {

    @Test
    public void testSubwindowStyles() throws IOException {
        openTestURL();

        compareScreen("initial_state");
    }
}
