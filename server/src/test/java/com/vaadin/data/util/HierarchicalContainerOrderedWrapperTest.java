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

public class HierarchicalContainerOrderedWrapperTest
        extends AbstractHierarchicalContainerTestBase {

    private HierarchicalContainerOrderedWrapper createContainer() {
        return new HierarchicalContainerOrderedWrapper(
                new ContainerHierarchicalWrapper(new IndexedContainer()));
    }

    @Test
    public void testBasicOperations() {
        testBasicContainerOperations(createContainer());
    }

    @Test
    public void testHierarchicalContainer() {
        testHierarchicalContainer(createContainer());
    }

    @Test
    public void testContainerOrdered() {
        testContainerOrdered(createContainer());
    }

    @Test
    public void testRemoveSubtree() {
        testRemoveHierarchicalWrapperSubtree(createContainer());
    }

}
