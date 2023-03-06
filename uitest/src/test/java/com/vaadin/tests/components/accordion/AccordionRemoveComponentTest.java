/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.accordion;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for removing component from Accordion
 *
 * @author Vaadin Ltd
 */
public class AccordionRemoveComponentTest extends MultiBrowserTest {

    @Test
    public void removeComponent_noClientSideException() {
        setDebug(true);
        openTestURL();

        $(ButtonElement.class).first().click();

        assertNoErrorNotifications();
    }

}
