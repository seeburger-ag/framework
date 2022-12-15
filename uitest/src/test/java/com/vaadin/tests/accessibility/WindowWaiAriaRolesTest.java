/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.accessibility;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.WindowElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test to see if regular and alert windows get the correct wai-aria roles
 *
 * @author Vaadin Ltd
 */
public class WindowWaiAriaRolesTest extends MultiBrowserTest {

    @Test
    public void testRegularWindowRole() {
        openTestURL();

        $(ButtonElement.class).caption("Regular").first().click();
        String role = getWindowRole();
        Assert.assertTrue(
                "Dialog has incorrect role '" + role + "', expected 'dialog'",
                "dialog".equals(role));
    }

    @Test
    public void testAlertWindowRole() {
        openTestURL();
        $(ButtonElement.class).caption("Alert").first().click();
        String role = getWindowRole();
        Assert.assertTrue(
                "Dialog has incorrect role '" + role
                        + "', expected 'alertdialog'",
                "alertdialog".equals(role));
    }

    public String getWindowRole() {
        return $(WindowElement.class).first().getAttribute("role");
    }
}
