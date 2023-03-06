/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class PopupViewAndFragmentTest extends MultiBrowserTest {

    @Test
    public void changeFragmentAndOpenPopupView() throws Exception {
        openTestURL();
        $(ButtonElement.class).first().click();
        // Wait for popup view to fully open
        sleep(1000);
        compareScreen("changedFragment");
    }
}
