/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.PopupViewElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DisabledPopupViewTest extends MultiBrowserTest {

    @Test
    public void disabledPopupDoesNotOpen() {
        openTestURL();

        $(PopupViewElement.class).first().click();

        assertFalse($(ButtonElement.class).exists());
    }
}