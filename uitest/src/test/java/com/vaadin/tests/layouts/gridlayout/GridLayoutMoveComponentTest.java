/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.gridlayout;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Test;

import java.io.IOException;

public class GridLayoutMoveComponentTest extends MultiBrowserTest {

    @Test
    public void componentsShouldMoveRight() throws IOException {
        openTestURL();

        compareScreen("all-left");

        clickButtonWithCaption("Shift label right");
        compareScreen("label-right");

        clickButtonWithCaption("Shift button right");
        compareScreen("label-button-right");

        clickButtonWithCaption("Shift text field right");
        compareScreen("label-button-textfield-right");
    }

    private void clickButtonWithCaption(String caption) {
        $(ButtonElement.class).caption(caption).first().click();
    }

}