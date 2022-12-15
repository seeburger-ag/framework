/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.vaadin.testbench.elements.GridElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class GridMultiSelectionScrollBarTest extends MultiBrowserTest {

    @Test
    public void testNoVisibleScrollBar() throws IOException {
        setDebug(true);
        openTestURL();

        assertTrue("Horizontal scrollbar should not be visible.",
                $(GridElement.class).first().getHorizontalScroller()
                        .getAttribute("style").toLowerCase()
                        .contains("display: none;"));

        // Just to make sure nothing odd happened.
        assertNoErrorNotifications();
    }

}
