/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class RefreshStatePreserveTitleTest extends MultiBrowserTest {
    @Test
    public void testReloadingPageDoesNotResetTitle() throws Exception {
        openTestURL();
        assertTitleText();
        openTestURL();
        assertTitleText();
    }

    private void assertTitleText() {
        Assert.assertEquals("Incorrect page title,", "TEST", driver.getTitle());
    }
}
