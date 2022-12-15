/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.abstractselect;

import org.junit.Test;

import com.vaadin.data.Container.ItemSetChangeEvent;
import com.vaadin.data.Container.ItemSetChangeListener;
import com.vaadin.data.Container.PropertySetChangeEvent;
import com.vaadin.data.Container.PropertySetChangeListener;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.ComboBox;

public class AbstractSelectListenersTest
        extends AbstractListenerMethodsTestBase {

    @Test
    public void testItemSetChangeListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(ComboBox.class, ItemSetChangeEvent.class,
                ItemSetChangeListener.class);
    }

    @Test
    public void testPropertySetChangeListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(ComboBox.class, PropertySetChangeEvent.class,
                PropertySetChangeListener.class);
    }
}
