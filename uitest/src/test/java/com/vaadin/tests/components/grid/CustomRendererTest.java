/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.vaadin.testbench.elements.GridElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.MultiBrowserTest;

@TestCategory("grid")
public class CustomRendererTest extends MultiBrowserTest {
    @Test
    public void testIntArrayIsRendered() throws Exception {
        openTestURL();

        GridElement grid = findGrid();
        assertEquals("1 :: 1 :: 2 :: 3 :: 5 :: 8 :: 13",
                grid.getCell(0, 0).getText());
    }

    @Test
    public void testRowAwareRenderer() throws Exception {
        openTestURL();

        GridElement grid = findGrid();
        assertEquals("Click me!", grid.getCell(0, 1).getText());
        assertEquals(CustomRenderer.INIT_DEBUG_LABEL_CAPTION,
                findDebugLabel().getText());

        grid.getCell(0, 1).click();
        assertEquals("row: 0, key: 1", grid.getCell(0, 1).getText());
        assertEquals("key: 1, itemId: " + CustomRenderer.ITEM_ID,
                findDebugLabel().getText());
    }

    @Test
    public void testBeanRenderer() throws Exception {
        openTestURL();

        assertEquals("SimpleTestBean(42)", findGrid().getCell(0, 2).getText());
    }

    private GridElement findGrid() {
        List<GridElement> elements = $(GridElement.class).all();
        return elements.get(0);
    }

    private LabelElement findDebugLabel() {
        return $(LabelElement.class).id(CustomRenderer.DEBUG_LABEL_ID);
    }
}
