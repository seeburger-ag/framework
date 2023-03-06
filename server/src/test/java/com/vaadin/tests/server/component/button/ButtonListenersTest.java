/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.button;

import org.junit.Test;

import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class ButtonListenersTest extends AbstractListenerMethodsTestBase {

    @Test
    public void testFocusListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(Button.class, FocusEvent.class,
                FocusListener.class);
    }

    @Test
    public void testBlurListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(Button.class, BlurEvent.class,
                BlurListener.class);
    }

    @Test
    public void testClickListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(Button.class, ClickEvent.class,
                ClickListener.class);
    }
}
