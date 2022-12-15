/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;

import org.easymock.EasyMock;
import org.junit.Test;

import com.vaadin.client.data.DataChangeHandler;
import com.vaadin.client.widget.grid.datasources.ListDataSource;

public class ListDataSourceTest {

    @Test
    public void testDataSourceConstruction() throws Exception {

        ListDataSource<Integer> ds = new ListDataSource<Integer>(0, 1, 2, 3);

        assertEquals(4, ds.size());
        assertEquals(0, (int) ds.getRow(0));
        assertEquals(1, (int) ds.getRow(1));
        assertEquals(2, (int) ds.getRow(2));
        assertEquals(3, (int) ds.getRow(3));

        ds = new ListDataSource<Integer>(Arrays.asList(0, 1, 2, 3));

        assertEquals(4, ds.size());
        assertEquals(0, (int) ds.getRow(0));
        assertEquals(1, (int) ds.getRow(1));
        assertEquals(2, (int) ds.getRow(2));
        assertEquals(3, (int) ds.getRow(3));
    }

    @Test
    public void testListAddOperation() throws Exception {

        ListDataSource<Integer> ds = new ListDataSource<Integer>(0, 1, 2, 3);

        DataChangeHandler handler = EasyMock
                .createNiceMock(DataChangeHandler.class);
        ds.setDataChangeHandler(handler);

        handler.dataAdded(4, 1);
        EasyMock.expectLastCall();

        EasyMock.replay(handler);

        ds.asList().add(4);

        assertEquals(5, ds.size());
        assertEquals(0, (int) ds.getRow(0));
        assertEquals(1, (int) ds.getRow(1));
        assertEquals(2, (int) ds.getRow(2));
        assertEquals(3, (int) ds.getRow(3));
        assertEquals(4, (int) ds.getRow(4));
    }

    @Test
    public void testListAddAllOperation() throws Exception {

        ListDataSource<Integer> ds = new ListDataSource<Integer>(0, 1, 2, 3);

        DataChangeHandler handler = EasyMock
                .createNiceMock(DataChangeHandler.class);
        ds.setDataChangeHandler(handler);

        handler.dataAdded(4, 3);
        EasyMock.expectLastCall();

        EasyMock.replay(handler);

        ds.asList().addAll(Arrays.asList(4, 5, 6));

        assertEquals(7, ds.size());
        assertEquals(0, (int) ds.getRow(0));
        assertEquals(1, (int) ds.getRow(1));
        assertEquals(2, (int) ds.getRow(2));
        assertEquals(3, (int) ds.getRow(3));
        assertEquals(4, (int) ds.getRow(4));
        assertEquals(5, (int) ds.getRow(5));
        assertEquals(6, (int) ds.getRow(6));
    }

    @Test
    public void testListRemoveOperation() throws Exception {

        ListDataSource<Integer> ds = new ListDataSource<Integer>(0, 1, 2, 3);

        DataChangeHandler handler = EasyMock
                .createNiceMock(DataChangeHandler.class);
        ds.setDataChangeHandler(handler);

        handler.dataRemoved(3, 1);
        EasyMock.expectLastCall();

        EasyMock.replay(handler);

        ds.asList().remove(2);

        assertEquals(3, ds.size());
        assertEquals(0, (int) ds.getRow(0));
        assertEquals(1, (int) ds.getRow(1));
        assertEquals(3, (int) ds.getRow(2));
    }

    @Test
    public void testListRemoveAllOperation() throws Exception {

        ListDataSource<Integer> ds = new ListDataSource<Integer>(0, 1, 2, 3);

        DataChangeHandler handler = EasyMock
                .createNiceMock(DataChangeHandler.class);
        ds.setDataChangeHandler(handler);

        handler.dataRemoved(0, 3);
        EasyMock.expectLastCall();

        EasyMock.replay(handler);

        ds.asList().removeAll(Arrays.asList(0, 2, 3));

        assertEquals(1, ds.size());
        assertEquals(1, (int) ds.getRow(0));
    }

    @Test
    public void testListClearOperation() throws Exception {

        ListDataSource<Integer> ds = new ListDataSource<Integer>(0, 1, 2, 3);

        DataChangeHandler handler = EasyMock
                .createNiceMock(DataChangeHandler.class);
        ds.setDataChangeHandler(handler);

        handler.dataRemoved(0, 4);
        EasyMock.expectLastCall();

        EasyMock.replay(handler);

        ds.asList().clear();

        assertEquals(0, ds.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testFetchingNonExistantItem() {
        ListDataSource<Integer> ds = new ListDataSource<Integer>(0, 1, 2, 3);
        ds.ensureAvailability(5, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedIteratorRemove() {
        ListDataSource<Integer> ds = new ListDataSource<Integer>(0, 1, 2, 3);
        ds.asList().iterator().remove();
    }

    @Test
    public void sortColumn() {
        ListDataSource<Integer> ds = new ListDataSource<Integer>(3, 4, 2, 3, 1);

        // TODO Should be simplified to sort(). No point in providing these
        // trivial comparators.
        ds.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        assertTrue(Arrays.equals(ds.asList().toArray(),
                new Integer[] { 1, 2, 3, 3, 4 }));
    }

}
