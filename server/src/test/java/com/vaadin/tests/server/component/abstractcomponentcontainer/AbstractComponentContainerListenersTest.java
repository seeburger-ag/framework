/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.abstractcomponentcontainer;

import org.junit.Test;

import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.HasComponents.ComponentAttachEvent;
import com.vaadin.ui.HasComponents.ComponentAttachListener;
import com.vaadin.ui.HasComponents.ComponentDetachEvent;
import com.vaadin.ui.HasComponents.ComponentDetachListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class AbstractComponentContainerListenersTest
        extends AbstractListenerMethodsTestBase {

    @Test
    public void testComponentDetachListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(HorizontalLayout.class,
                ComponentDetachEvent.class, ComponentDetachListener.class);
    }

    @Test
    public void testComponentAttachListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(VerticalLayout.class,
                ComponentAttachEvent.class, ComponentAttachListener.class);
    }
}
