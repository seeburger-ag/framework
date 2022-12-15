/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import org.junit.Test;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class PushWithRequireJSTest extends SingleBrowserTest {

    @Test
    public void testPushWithRequireJS() {
        setDebug(true);
        openTestURL();
        assertNoErrorNotifications();
    }

}
