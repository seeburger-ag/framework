/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.atmosphere.cpr.AtmosphereResource;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import com.vaadin.server.communication.AtmospherePushConnection.State;
import com.vaadin.ui.UI;

public class AtmospherePushConnectionTest {
    @Test
    public void testSerialization() throws Exception {

        UI ui = EasyMock.createNiceMock(UI.class);
        AtmosphereResource resource = EasyMock
                .createNiceMock(AtmosphereResource.class);

        AtmospherePushConnection connection = new AtmospherePushConnection(ui);
        connection.connect(resource);

        Assert.assertEquals(State.CONNECTED, connection.getState());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        new ObjectOutputStream(baos).writeObject(connection);

        connection = (AtmospherePushConnection) new ObjectInputStream(
                new ByteArrayInputStream(baos.toByteArray())).readObject();

        Assert.assertEquals(State.DISCONNECTED, connection.getState());
    }
}
