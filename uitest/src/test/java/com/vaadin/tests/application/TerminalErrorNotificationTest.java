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

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.NotificationElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.tests.tb3.newelements.FixedNotificationElement;

public class TerminalErrorNotificationTest extends MultiBrowserTest {
    @Test
    public void tb2test() throws Exception {
        openTestURL();
        $(ButtonElement.class).first().click();
        Assert.assertTrue(isElementPresent(NotificationElement.class));
        Assert.assertEquals("Got an exception: You asked for it",
                $(FixedNotificationElement.class).first().getCaption());
    }
}
