/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.embedded;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.Embedded;

public class EmbeddedListenersTest extends AbstractListenerMethodsTestBase {
    public void testClickListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(Embedded.class, ClickEvent.class,
                ClickListener.class);
    }
}
