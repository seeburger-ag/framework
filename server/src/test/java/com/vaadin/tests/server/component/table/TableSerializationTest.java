/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.table;

import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;

import com.vaadin.ui.Table;

public class TableSerializationTest {

    @Test
    public void testSerialization() {
        Table t = new Table();
        byte[] ser = SerializationUtils.serialize(t);
        Table t2 = (Table) SerializationUtils.deserialize(ser);

    }

    @Test
    public void testSerializationWithRowHeaders() {
        Table t = new Table();
        t.setRowHeaderMode(Table.ROW_HEADER_MODE_EXPLICIT);
        t.setColumnWidth(null, 100);
        byte[] ser = SerializationUtils.serialize(t);
        Table t2 = (Table) SerializationUtils.deserialize(ser);
    }
}
