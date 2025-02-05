/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.grid;

import static org.junit.Assert.assertFalse;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.AbstractInMemoryContainer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;

public class GridContainerNotSortableTest {

    final AbstractInMemoryContainer<Object, Object, Item> notSortableDataSource = new AbstractInMemoryContainer<Object, Object, Item>() {

        private Map<Object, Property<?>> properties = new LinkedHashMap<Object, Property<?>>();

        {
            properties.put("Foo", new Property<String>() {

                @Override
                public String getValue() {
                    return "foo";
                }

                @Override
                public void setValue(String newValue) throws ReadOnlyException {
                    throw new ReadOnlyException();
                }

                @Override
                public Class<? extends String> getType() {
                    return String.class;
                }

                @Override
                public boolean isReadOnly() {
                    return true;
                }

                @Override
                public void setReadOnly(boolean newStatus) {
                    throw new UnsupportedOperationException();
                }
            });
        }

        @Override
        public Collection<?> getContainerPropertyIds() {
            return properties.keySet();
        }

        @Override
        public Property getContainerProperty(Object itemId, Object propertyId) {
            return properties.get(propertyId);
        }

        @Override
        public Class<?> getType(Object propertyId) {
            return properties.get(propertyId).getType();
        }

        @Override
        protected Item getUnfilteredItem(Object itemId) {
            return null;
        }
    };

    @Test
    public void testGridWithNotSortableContainer() {
        new Grid(notSortableDataSource);
    }

    @Test(expected = IllegalStateException.class)
    public void testNotSortableGridSetColumnSortable() {
        Grid grid = new Grid();
        grid.setContainerDataSource(notSortableDataSource);
        Column column = grid.getColumn("Foo");
        assertFalse("Column should not be sortable initially.",
                column.isSortable());
        column.setSortable(true);
    }
}
