/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.treetable;

import org.junit.Test;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class TreeTableRowGeneratorTest extends SingleBrowserTest {

    @Test
    public void testNoExceptionOnRender() {
        setDebug(true);
        openTestURL();

        assertNoErrorNotifications();
    }
}
