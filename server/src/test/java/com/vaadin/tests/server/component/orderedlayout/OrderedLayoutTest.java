/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.orderedlayout;

import java.util.Iterator;

import org.junit.Test;

import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class OrderedLayoutTest {

    @Test
    public void testVLIteration() {
        testIndexing(new VerticalLayout(), 10);
    }

    @Test
    public void testHLIteration() {
        testIndexing(new HorizontalLayout(), 12);
    }

    public void testIndexing(AbstractOrderedLayout aol, int nrComponents) {
        Component[] components = generateComponents(nrComponents);
        for (Component c : components) {
            aol.addComponent(c);
        }
        for (int i = 0; i < nrComponents; i++) {
            assert (aol.getComponent(i) == components[i]);
            assert (aol.getComponentIndex(components[i]) == i);
        }

        // Iteration should be in indexed order
        int idx = 0;
        for (Iterator<Component> i = aol.getComponentIterator(); i.hasNext();) {
            Component c = i.next();
            assert (aol.getComponentIndex(c) == idx++);
        }
    }

    private Component[] generateComponents(int nr) {
        Component[] components = new Component[nr];
        for (int i = 0; i < nr; i++) {
            components[i] = new Label("" + i);
        }

        return components;
    }
}
