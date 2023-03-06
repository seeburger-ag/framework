/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.csslayout;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.CssLayout;

public class CssLayoutListenersTest extends AbstractListenerMethodsTestBase {
    public void testLayoutClickListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(CssLayout.class, LayoutClickEvent.class,
                LayoutClickListener.class);
    }
}
