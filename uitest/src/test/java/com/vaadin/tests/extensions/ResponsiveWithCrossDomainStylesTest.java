/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.extensions;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class ResponsiveWithCrossDomainStylesTest extends MultiBrowserTest {
    @Test
    public void testResponsive() {
        setDebug(true);
        openTestURL();

        $(ButtonElement.class).first().click();

        assertNoErrorNotifications();
    }

}
