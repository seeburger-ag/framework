/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertionsEnabledTest {

    @Test
    public void testAssertionsEnabled() {
        boolean assertFailed = false;
        try {
            assert false;
        } catch (AssertionError e) {
            assertFailed = true;
        } finally {
            assertTrue("Unit tests should be run with assertions enabled",
                    assertFailed);
        }
    }
}
