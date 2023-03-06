/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests that a user is notified about a missing component from the widgetset
 */
public class UnknownComponentConnectorTest extends MultiBrowserTest {

    @Test
    public void testConnectorNotFoundInWidgetset() throws Exception {
        openTestURL();
        WebElement component = vaadinElementById("no-connector-component");
        assertTrue(component.getText().startsWith(
                "Widgetset 'com.vaadin.DefaultWidgetSet' does not contain an "
                        + "implementation for com.vaadin.tests.components.UnknownComponentConnector."
                        + "ComponentWithoutConnector."));
    }
}
