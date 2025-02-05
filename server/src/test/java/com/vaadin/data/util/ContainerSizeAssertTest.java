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

import com.vaadin.data.Container;
import com.vaadin.ui.Table;

public class ContainerSizeAssertTest {

    @Test(expected = AssertionError.class)
    public void testNegativeSizeAssert() {
        Table table = createAttachedTable();

        table.setContainerDataSource(createNegativeSizeContainer());
    }

    @Test
    public void testZeroSizeNoAssert() {
        Table table = createAttachedTable();

        table.setContainerDataSource(new IndexedContainer());
    }

    private Container createNegativeSizeContainer() {
        return new IndexedContainer() {
            @Override
            public int size() {
                return -1;
            }
        };
    }

    private Table createAttachedTable() {
        return new Table() {
            private boolean initialized = true;

            @Override
            public boolean isAttached() {
                // This returns false until the super constructor has finished
                return initialized;
            }
        };
    }
}
