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

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class ExtensionTest {

    public static class DummyExtension extends AbstractExtension {
        public DummyExtension(AbstractClientConnector target) {
            super(target);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveExtensionFromWrongConnector() {
        Label l = new Label();
        TextField t = new TextField();
        t.removeExtension(new DummyExtension(l));
    }

}
