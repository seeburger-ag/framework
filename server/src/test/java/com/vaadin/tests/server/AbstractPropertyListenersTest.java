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

import com.vaadin.data.Property.ReadOnlyStatusChangeEvent;
import com.vaadin.data.Property.ReadOnlyStatusChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.AbstractProperty;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;

public class AbstractPropertyListenersTest
        extends AbstractListenerMethodsTestBase {

    @Test
    public void testValueChangeListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(AbstractProperty.class, ValueChangeEvent.class,
                ValueChangeListener.class, new ObjectProperty<String>(""));
    }

    @Test
    public void testReadOnlyStatusChangeListenerAddGetRemove()
            throws Exception {
        testListenerAddGetRemove(AbstractProperty.class,
                ReadOnlyStatusChangeEvent.class,
                ReadOnlyStatusChangeListener.class,
                new ObjectProperty<String>(""));
    }
}
