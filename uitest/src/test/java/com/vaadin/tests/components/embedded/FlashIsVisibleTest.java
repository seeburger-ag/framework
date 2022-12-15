/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.embedded;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FlashIsVisibleTest
        extends com.vaadin.tests.components.flash.FlashIsVisibleTest {

    @Override
    @Test
    public void testFlashIsCorrectlyDisplayed() throws Exception {
        assertTrue("Test is using wrong url",
                getTestUrl().contains(".embedded."));
        super.testFlashIsCorrectlyDisplayed();
    }
}
