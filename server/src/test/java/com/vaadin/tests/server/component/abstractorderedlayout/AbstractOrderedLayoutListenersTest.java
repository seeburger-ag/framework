/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.abstractorderedlayout;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.VerticalLayout;

public class AbstractOrderedLayoutListenersTest
        extends AbstractListenerMethodsTestBase {
    public void testLayoutClickListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(VerticalLayout.class, LayoutClickEvent.class,
                LayoutClickListener.class);
    }
}
