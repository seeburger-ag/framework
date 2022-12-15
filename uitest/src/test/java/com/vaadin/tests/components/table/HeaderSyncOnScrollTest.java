/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import java.io.IOException;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TableElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Tests Table Footer ClickListener
 *
 * @since
 * @author Vaadin Ltd
 */
public class HeaderSyncOnScrollTest extends MultiBrowserTest {

    @Test
    public void testFooter() throws IOException {
        openTestURL();

        $(ButtonElement.class).first().click();

        compareScreen("100pct-no-scrollbar");

        $(ButtonElement.class).get(1).click();

        TableElement first = $(TableElement.class).first();
        first.scrollLeft(200);

        compareScreen("300px-scrolled-right");

        $(ButtonElement.class).get(2).click();

        compareScreen("100pct-no-scrollbar-second");
    }

}
