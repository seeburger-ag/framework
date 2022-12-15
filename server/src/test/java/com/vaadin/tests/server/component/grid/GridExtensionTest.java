/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.grid;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.AbstractGridExtension;

public class GridExtensionTest {

    public static class DummyGridExtension extends AbstractGridExtension {

        public DummyGridExtension(Grid grid) {
            super(grid);
        }
    }

    @Test
    public void testCreateExtension() {
        Grid grid = new Grid();
        DummyGridExtension dummy = new DummyGridExtension(grid);
        assertTrue("DummyGridExtension never made it to Grid",
                grid.getExtensions().contains(dummy));
    }
}
