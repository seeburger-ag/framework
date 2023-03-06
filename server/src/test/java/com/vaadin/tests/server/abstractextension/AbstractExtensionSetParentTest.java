/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.abstractextension;

import org.junit.Test;
import org.mockito.Mockito;

import com.vaadin.server.AbstractExtension;
import com.vaadin.server.ClientConnector;

public class AbstractExtensionSetParentTest {

    private static class TestExtension extends AbstractExtension {

    }

    @Test
    public void setParent_marks_old_parent_as_dirty() {
        ClientConnector connector = Mockito.mock(ClientConnector.class);
        TestExtension extension = new TestExtension();
        extension.setParent(connector);
        extension.setParent(null);
        Mockito.verify(connector, Mockito.times(1)).markAsDirty();
    }
}
