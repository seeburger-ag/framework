/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.tests.components.grid.basicfeatures.GridBasicFeaturesTest;

public class GridColumnMaxWidthTest extends GridBasicFeaturesTest {

    @Test
    public void testMaxWidthAffectsColumnWidth() {
        setDebug(true);
        openTestURL();

        selectMenuPath("Component", "Columns",
                "All columns expanding, Col 0 has max width of 30px");

        assertEquals("Column 0 did not obey max width of 30px.", 30,
                getGridElement().getCell(0, 0).getSize().getWidth());
    }
}