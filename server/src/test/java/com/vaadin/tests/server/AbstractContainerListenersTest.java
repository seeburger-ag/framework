/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server;

import org.junit.Test;

import com.vaadin.data.Container.ItemSetChangeEvent;
import com.vaadin.data.Container.ItemSetChangeListener;
import com.vaadin.data.Container.PropertySetChangeEvent;
import com.vaadin.data.Container.PropertySetChangeListener;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;

public class AbstractContainerListenersTest
        extends AbstractListenerMethodsTestBase {

    @Test
    public void testItemSetChangeListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(IndexedContainer.class,
                ItemSetChangeEvent.class, ItemSetChangeListener.class);
    }

    @Test
    public void testPropertySetChangeListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(IndexedContainer.class,
                PropertySetChangeEvent.class, PropertySetChangeListener.class);
    }
}
