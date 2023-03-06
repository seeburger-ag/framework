/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class GridDisabledTest extends MultiBrowserTest {

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        // Grids current DOM/CSS structure doesn't allow
        // opacity to work properly in IE8.
        return getBrowsersExcludingIE8();
    }

    @Test
    public void disabledGrid() throws IOException {
        openTestURL();

        $(ButtonElement.class).caption("Disable").first().click();

        compareScreen("disabled");
    }
}