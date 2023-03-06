/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server;

import com.vaadin.data.Item.PropertySetChangeEvent;
import com.vaadin.data.Item.PropertySetChangeListener;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;

public class PropertysetItemListenersTest
        extends AbstractListenerMethodsTestBase {
    public void testPropertySetChangeListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(PropertysetItem.class,
                PropertySetChangeEvent.class, PropertySetChangeListener.class);
    }
}
