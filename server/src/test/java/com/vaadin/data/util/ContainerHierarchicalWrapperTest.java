/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util;

import org.junit.Test;

public class ContainerHierarchicalWrapperTest
        extends AbstractHierarchicalContainerTestBase {

    @Test
    public void testBasicOperations() {
        testBasicContainerOperations(
                new ContainerHierarchicalWrapper(new IndexedContainer()));
    }

    @Test
    public void testHierarchicalContainer() {
        testHierarchicalContainer(
                new ContainerHierarchicalWrapper(new IndexedContainer()));
    }

    @Test
    public void testRemoveSubtree() {
        testRemoveHierarchicalWrapperSubtree(
                new ContainerHierarchicalWrapper(new IndexedContainer()));
    }

}
