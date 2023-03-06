/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.gridlayout;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.AbstractTB3Test;
import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MoveComponentsFromGridLayoutToInnerLayoutTest
        extends MultiBrowserTest {

    @Test
    public void buttonIsMovedInsideInnerLayout() throws IOException {
        openTestURL();

        $(ButtonElement.class).first().click();

        compareScreen("buttonClicked");
    }
}