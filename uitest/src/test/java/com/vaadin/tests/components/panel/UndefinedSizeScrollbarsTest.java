/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.panel;

import java.io.IOException;

import org.junit.Test;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class UndefinedSizeScrollbarsTest extends MultiBrowserTest {

    @Test
    public void testNoScrollbars() throws IOException {
        openTestURL();
        compareScreen("noscrollbars");
    }
}
