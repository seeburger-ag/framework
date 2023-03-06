/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.absolutelayout;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;

/**
 * Tests adding of components to {@link AbsoluteLayout}
 *
 * @since
 * @author Vaadin Ltd
 */
public class AddComponentsTest {

    @Test
    public void testAddExistingWithDifferentPosition() {
        AbsoluteLayout layout = new AbsoluteLayout();
        Button b1 = new Button("OK");
        layout.addComponent(b1, "top: 100px; left: 0px;");
        assertEquals(1, layout.getComponentCount());
        layout.addComponent(b1, "bottom: 0px; right: 0px;");
        assertEquals(1, layout.getComponentCount());
    }

}
