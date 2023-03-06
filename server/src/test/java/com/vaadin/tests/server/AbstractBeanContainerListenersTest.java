/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server;

import com.vaadin.data.Container.PropertySetChangeEvent;
import com.vaadin.data.Container.PropertySetChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;

public class AbstractBeanContainerListenersTest
        extends AbstractListenerMethodsTestBase {
    public void testPropertySetChangeListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(BeanItemContainer.class,
                PropertySetChangeEvent.class, PropertySetChangeListener.class,
                new BeanItemContainer<PropertySetChangeListener>(
                        PropertySetChangeListener.class));
    }
}
