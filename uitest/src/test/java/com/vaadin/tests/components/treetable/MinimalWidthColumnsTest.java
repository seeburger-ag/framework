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

import com.vaadin.tests.tb3.MultiBrowserTest;

public class MinimalWidthColumnsTest extends MultiBrowserTest {

    @Test
    public void testFor1pxDifference() throws Exception {
        openTestURL();
        sleep(500);
        compareScreen("onepixdifference");
    }

}
