/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.panel;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.Panel;

public class PanelListenersTest extends AbstractListenerMethodsTestBase {
    public void testClickListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(Panel.class, ClickEvent.class,
                ClickListener.class);
    }
}
