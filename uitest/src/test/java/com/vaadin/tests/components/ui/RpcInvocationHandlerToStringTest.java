/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.NotificationElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class RpcInvocationHandlerToStringTest extends MultiBrowserTest {
    @Test
    public void testMethodsOnInvocationProxy() throws Exception {
        openTestURL();
        execMethodForProxy("toString()");
        execMethodForProxy("hashCode()");
        execMethodForProxy("equals(false)");
    }

    private void execMethodForProxy(String method) {
        $(ButtonElement.class)
                .caption("Exec " + method + " for an invocation proxy").first()
                .click();
        Assert.assertFalse(
                method + " for invocation proxy caused a notification",
                $(NotificationElement.class).exists());
    }
}
